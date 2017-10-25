package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Entity.Staff;
import com.example.repository.StaffRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceFeesApplicationTests {

	@Autowired
	private StaffRepository staffrepository;
	
	@Test
	public void contextLoads() {
		List<Staff> liststaff= staffrepository.findAll();
		System.out.println(liststaff.size());
		
	}

}
