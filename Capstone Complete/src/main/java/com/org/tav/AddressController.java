package com.org.tav;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddressController {
	@Autowired
	AddressRepository adrepo;
	
	
	@RequestMapping("/")
	public String home()
	{
		return("home");
	}
	@RequestMapping("/saveaddress")
	public String saveaddress(Address addr)
	{
		adrepo.save(addr);
		return("home");
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(HttpServletRequest request) {
		return adrepo.search(request.getParameter("term"));
	}
	
	@GetMapping("/searchsimilar")
	public ModelAndView searchsimilar(@RequestParam("simi") String sim)
	{
		ModelAndView mv=new ModelAndView("home");
		List<Address> ls=adrepo.findsimilar(sim);
		mv.addObject("sms",ls);
		return mv;		
	}
	
	
	@PostMapping("/savefile")
	public String savefile(@RequestParam("fil") MultipartFile file) throws IOException
	{
		InputStream istream=file.getInputStream();
		String eachline;
		List<Address> fileadd=new ArrayList<>();
		BufferedReader reader=new BufferedReader(new InputStreamReader(istream));
		while((eachline =reader.readLine())!= null)
		{
			fileadd.add(new Address(eachline));
		}
		reader.close();
		adrepo.saveAll(fileadd);
		return ("home");
	}
	
	
	
	
	

}
