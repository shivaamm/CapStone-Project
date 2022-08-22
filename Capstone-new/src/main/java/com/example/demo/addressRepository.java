package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface addressRepository extends JpaRepository<User, Integer> {
	
	@Query(value="SELECT address FROM adresses where address like %:keyword%",nativeQuery=true)
	public List<String> search(@Param("keyword") String keyword);
	 
}
