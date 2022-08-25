package com.org.tav;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.tav.pojo.Address;
import com.org.tav.repo.AddressRepository;
import com.org.tav.service.AddressService;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AddressManagerApplicationTests {

	
	@Autowired
	private AddressService servi;
	
	@MockBean
	private AddressRepository repo;
	
	@Test
	@DisplayName("Save Address Test")
	public void saveaddTest()
	{
		Address a=new Address("satuluru");
		when(repo.save(a)).thenReturn(a);
		assertEquals(a,servi.saveaddr(a));
		
	}
	
	@Test
	@DisplayName("Similar 5 Test")
	public void similarfiveTest()
	{
		String s="main road";
		when(repo.findsimilar(s)).thenReturn(Stream.of(new Address("main plaza"),new Address("main road")).collect(Collectors.toList()));
		assertEquals(2, servi.get5similar(s).size());
	}
	
	@SuppressWarnings("resource")
	@Test
	@DisplayName("File Save Test")
	public void filesaveTest() throws IOException
	{
		MockMultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "Amaravathi\nKadapa".getBytes());
        Address a2=new Address("Amaravathi");
        Address a1=new Address("Kadapa");
        when(repo.save(a1)).thenReturn(a1);
        when(repo.save(a2)).thenReturn(a2);
        assertEquals(2, servi.fileupload(file).size());
    
		
		/*FileInputStream f = new FileInputStream("C:\\Users\\inavolu.rajendra\\OneDrive - Tavant Technologies\\Desktop\\cap.txt");
		BufferedReader reader=new BufferedReader(new InputStreamReader(f));
		String eachline=reader.readLine();
		Address a1=new Address(eachline);
		when(repo.save(a1)).thenReturn(a1);
		assertEquals(a1,servi.saveaddr(a1));*/
		
	}

}
