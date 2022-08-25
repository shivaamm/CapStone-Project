package com.org.tav.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.tav.pojo.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{


	@Query(value="select * from address order by similarity(addr,?1) desc limit 5",nativeQuery = true)
	public List<Address> findsimilar(String si);
	
	@Query(value="SELECT addr FROM address where addr like :keyword%",nativeQuery=true)
	public List<String> search(@Param("keyword") String keyword);

	

	
	

}
