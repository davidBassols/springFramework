package com.guru.springframework.spring5WebApp.bootstrap;

import java.util.Iterator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.guru.springframework.spring5WebApp.domain.Author;
import com.guru.springframework.spring5WebApp.domain.Book;
import com.guru.springframework.spring5WebApp.domain.Publisher;
import com.guru.springframework.spring5WebApp.repositories.AuthorRepository;
import com.guru.springframework.spring5WebApp.repositories.BookRepository;
import com.guru.springframework.spring5WebApp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "3939459459");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		System.out.println("Starting in Bootstrap");
		System.out.println("Number of Books: "+bookRepository.count());
		
		Publisher publisher = new Publisher("MyPublisher", "addressLine1", "Olot", "Catalunya", "17800");
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		publisherRepository.save(publisher);
		
		System.out.println("And publisher: "+publisherRepository.count());
		System.out.println("Number of books "+publisher.getBooks().size());
		System.out.println(publisher);
	}
}
