package com.JPAPerformanceProject;

import java.util.List;

import javax.persistence.PersistenceUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.JPAPerformanceProject.dao.EmployeeDao;
import com.JPAPerformanceProject.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaPerformanceProjectApplicationTests {

	
	@Autowired
	EmployeeDao dao;
	
	@Test
	public void contextLoads() {
	}

	
	@Test
	public void getEmpTest() {
		
		List<Employee> emp = dao.find();
		
		for(Employee e:emp) {
			System.out.println(e.getName());
			
		}
		
		
	}
	
	
	
}
