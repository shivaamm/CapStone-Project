package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.transaction.Transactional;

@Transactional
@Service("AddressService")
public class AddressServiceTrans implements AddressService{
	
	@Autowired
	private addressRepository addRepo;
	
    public void addUser(User address) {
    	System.out.println("peeka-boo");
    	addRepo.save(address);
    	
    }

	@Override
	public List<String> search(String keyword) {
		return addRepo.search(keyword);
	}

}
