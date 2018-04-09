package com.JPAPerformanceProject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUtil;
import javax.persistence.Query;
import javax.persistence.Subgraph;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.websocket.Session;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.JPAPerformanceProject.entity.Employee;
import com.JPAPerformanceProject.entity.Sprints;

@Repository
@Transactional(readOnly=true)
public class EmployeeDao {
	
	@PersistenceContext
    EntityManager em;

    public List<Employee> findUsingDistinct() {
        String sql = " select DISTINCT e " 
                     + " from Employee e "
                     + " left join fetch e.projects p  "
                     + " where e.delete_in=0 "
                     //+ " and  e.id=p.id "
                     ;

        Query query = em.createQuery(sql,Employee.class);
        
        List<Employee> emp = query.getResultList();
       PersistenceUtil pu =  em.getEntityManagerFactory().getPersistenceUnitUtil();
       
       for(Employee e:emp) {
			System.out.println(" getName " + pu.isLoaded(e.getName()));
			
			System.out.println(" getProjects "+ pu.isLoaded(e.getProjects()));
			
		}
       

        return emp;
    }
    
    
    public List<Employee> findB() {
        String sql = " select  e " 
                     + " from Employee e "
                     //+ " where e.delete_in=0 "
                     //+ " and  e.id=p.id "
                     ;

        Query query = em.createQuery(sql,Employee.class);
        
        List<Employee> emp = query.getResultList();
       PersistenceUtil pu =  em.getEntityManagerFactory().getPersistenceUnitUtil();
       
       //System.out.println(" 0--> " + emp.get(0).getProjects().get(0).getProject_name());
       
       for(Employee e:emp) {
			System.out.println(" getName " + pu.isLoaded(e.getName()));
			
			System.out.println(" getProjects "+ pu.isLoaded(e.getProjects()));
			
		}
       

        return emp;
    }
    
    
    public List<Employee> findEgraph() {
       /*
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> q = cb.createQuery(Employee.class);
        
        Root<Employee> o = q.from(Employee.class);
        o.fetch("projects",JoinType.LEFT);
        q.select(o);
        
        
        List<Employee> emp = (List<Employee>) (this.em.createQuery(q).getResultList());*/
        //Query query = em.createQuery(sql,Employee.class);
        
    	
    	EntityGraph<Employee> g = em.createEntityGraph(Employee.class);
    	
    	Subgraph itemGraph = g.addSubgraph("projects");
    	
    	Subgraph sprintGraph = itemGraph.addSubgraph("sprints");
        
    	
    	List<Employee> emp = (List<Employee>) em.createQuery("select e from Employee e").setHint("javax.persistence.loadgraph", g).getResultList();
    	
       PersistenceUtil pu =  em.getEntityManagerFactory().getPersistenceUnitUtil();
       
       //System.out.println(" 0--> " + emp.get(0).getProjects().get(0).getProject_name());
       int i=0;
       for(Employee e:emp) {
			System.out.println(" getName " + pu.isLoaded(e.getName()));
			
			System.out.println(" getProjects "+ pu.isLoaded(e.getProjects()));
			
			System.out.println(" getSprints "+ pu.isLoaded(e.getProjects().get(0).getSprints()));
			
			for(Sprints s:e.getProjects().get(0).getSprints()) {
				System.out.println("Sprint no " + s.getSprint_no());
			}
			
		}
       

        return emp;
    }
    

    public List<Employee> find() {
     	
     	
    	
    	em.unwrap(org.hibernate.Session.class).enableFetchProfile("Employee_Projects");
     	List<Employee> emp = (List<Employee>) em.createQuery("select e from Employee e").getResultList();
     	
        PersistenceUtil pu =  em.getEntityManagerFactory().getPersistenceUnitUtil();
        
        //System.out.println(" 0--> " + emp.get(0).getProjects().get(0).getProject_name());
        int i=0;
        for(Employee e:emp) {
 			System.out.println(" getName " + pu.isLoaded(e.getName()));
 			
 			System.out.println(" getProjects "+ pu.isLoaded(e.getProjects()));
 			
 			//System.out.println(" getSprints "+ pu.isLoaded(e.getProjects().get(0).getSprints()));
 			
 			/*for(Sprints s:e.getProjects().get(0).getSprints()) {
 				System.out.println("Sprint no " + s.getSprint_no());
 			}*/
 			
 		}
        

         return emp;
     }
     

    
    

}
