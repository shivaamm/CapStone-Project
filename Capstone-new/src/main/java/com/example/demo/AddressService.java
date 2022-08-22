package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface AddressService {
	public List<String> search(String keyword);



	public void addUser(User address);

}
