package com.spring5.springdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.spring5.springdemo.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
