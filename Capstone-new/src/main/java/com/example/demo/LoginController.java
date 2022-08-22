package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("adresses")
public class LoginController {
//    @RequestMapping("/")
//    public String init(Model model) {
//        model.addAttribute("msg", "Please Enter Your Login Details");
//        return "address";
//    }
//    
    
    @Autowired
    private AddressService addressservice;
//    private addressRepository adRepo;
    
       
//    @GetMapping("/users")
//    public String listAll(Model model) {
//        List<User> listStudents = adRepo.findAll();
//        model.addAttribute("listStudents", listStudents);
//           
//        return "address";
//    }
    
    @RequestMapping("/")
	public String index() {
		return "index";
	}
    
    @RequestMapping("/addusers")
    public String addUser(Model model,User address) {
    	System.out.println("heii login ");
    	addressservice.addUser(address);
		return "index";
    	
    }
    
    
    
    
    
    @RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(HttpServletRequest request) {
		return addressservice.search(request.getParameter("term"));
	}
    
}