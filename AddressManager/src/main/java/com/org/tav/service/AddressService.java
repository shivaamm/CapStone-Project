package com.org.tav.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.org.tav.pojo.Address;
import com.org.tav.repo.AddressRepository;

@Service
public class AddressService {
	@Autowired
    AddressRepository adrepo;
	
	public Address saveaddr(Address address)
    {
        return adrepo.save(address);
    }
	
	public List<Address> get5similar(String s)
    {
        return adrepo.findsimilar(s);
    }
	public List<String> searching(String se)
    {
        return adrepo.search(se);
    }
	public List<Address> fileupload(MultipartFile file) throws IOException
    {
		InputStream istream=file.getInputStream();
		String eachline;
		List<Address> fileadd=new ArrayList<>();
		BufferedReader reader=new BufferedReader(new InputStreamReader(istream));
		while((eachline =reader.readLine())!= null)
		{
			fileadd.add(new Address(eachline));
		}
		List<Address> ad=new ArrayList<>();
		for (Address a : fileadd) {
			ad.add(adrepo.save(a));
			
		}
		reader.close();
         return ad;
    }
}
