package com.org.tav.controller;

import java.io.IOException;
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

import com.org.tav.pojo.Address;
import com.org.tav.service.AddressService;

@Controller
public class AddressController {
	
	
	@Autowired
	AddressService adser;
	
	
	@RequestMapping("/")
	public String home()
	{
		return("home");
	}
	@RequestMapping("/saveaddress")
	public String saveaddress(Address addr) throws Exception
	{
		adser.saveaddr(addr);
		return("home");
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(HttpServletRequest request) {
		return adser.searching(request.getParameter("term"));
	}
	
	
	@GetMapping("/searchsimilar")
	public ModelAndView searchsimilar(@RequestParam("simi") String sim)
	{
		ModelAndView mv=new ModelAndView("home");
		List<Address> ls=adser.get5similar(sim);
		mv.addObject("sms",ls);
		return mv;		
	}
	
	
	@PostMapping("/savefile")
	public String savefile(@RequestParam("fil") MultipartFile file) throws IOException
	{
		
		adser.fileupload(file);
		return ("home");
	}
	
	
	
	
	

}
