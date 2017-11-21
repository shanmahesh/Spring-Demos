package com.spring5.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring5.springdemo.repositories.BookRepository;

@Controller
public class BooksController {

	private BookRepository bookRepo;

	public BooksController(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books",bookRepo.findAll());
		
	
		return "books";
	}
	
}
