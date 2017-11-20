package com.spring5.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring5.springdemo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
