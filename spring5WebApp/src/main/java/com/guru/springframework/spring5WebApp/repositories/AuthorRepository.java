package com.guru.springframework.spring5WebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.guru.springframework.spring5WebApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
