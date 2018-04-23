/**
 * 
 */
package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.domain.Org;
import com.org.infrastructure.JpaOrgRepository;

/**
 * @author Mahesh S
 *
 */
@RestController
@RequestMapping("/")
public class OrgController {
	
	@Autowired
	JpaOrgRepository repo;
	
	@RequestMapping(path="/addOrg")
	public void addOrg() {
		Org o = new Org();
		o.setName("Vin org 2222");
		o.setOrgType("Employer 2323");
		o.setRptgunitType("SD");
		repo.save(o);
		
		Iterable<Org> orgs = repo.findAll();
		
		orgs.forEach(p->{
			System.out.println(p.toString());
		});
		
	}

}
