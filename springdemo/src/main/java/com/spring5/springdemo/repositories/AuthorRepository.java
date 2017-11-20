package com.spring5.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring5.springdemo.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
