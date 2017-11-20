package com.spring5.springdemo.bootstrap;

import java.util.HashSet;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.spring5.springdemo.model.Author;
import com.spring5.springdemo.model.Book;
import com.spring5.springdemo.model.Publisher;
import com.spring5.springdemo.repositories.AuthorRepository;
import com.spring5.springdemo.repositories.BookRepository;
import com.spring5.springdemo.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>  {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	
	
	

	private void initData(){
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("ddd","123");
		Publisher p1 = new Publisher("AMZN", "Seatle,WA");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(p1);
		
		publisherRepository.save(p1);
		authorRepository.save(eric);
		
		bookRepository.save(ddd);
		
		
		
		Author rob = new Author("Rob","Adam");
		Book noEJB = new Book("Java No EJB","222");
		Publisher p2 = new Publisher("BN", "Milwaukee,WA");
		
		rob.getBooks().add(noEJB);
		noEJB.getAuthors().add(rob);
		noEJB.setPublisher(p2);
		
		publisherRepository.save(p2);
		authorRepository.save(rob);
		
		bookRepository.save(noEJB);
		
	}





	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		initData();
		
	}
	
	
	
}
