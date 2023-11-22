package com.spaces.bookStore.bootstrap;

import com.spaces.bookStore.repository.AuthorRepository;
import com.spaces.bookStore.repository.BookRepository;
import com.spaces.bookStore.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//
//        System.out.println("Starting Bootstrap");
//
//        Publisher publisher = new Publisher() ;
//        publisher.setName( "SFG Publishing" );
//        publisher.setCity( "St Petersburg" );
//        publisher.setState( "FL");
//
//        publisherRepository.save(publisher) ;
//        System.out.println( "Publisher Count: " + publisherRepository .count()) ;
//
//        Author eric = new Author("Eric", "Evans");
//        Book ddd = new Book("Domain Driven Design" , "123123" );
//        eric.getBooks().add(ddd) ;
//        ddd.getAuthors().add(eric) ;
//        ddd.setPublisher(publisher) ;
//        publisher.getBooks().add(ddd) ;
//        authorRepository.save(eric) ;
//        bookRepository.save(ddd) ;
//        publisherRepository .save(publisher) ;
//
//
//        Author rod = new Author("Rod", "Johnson" );
//        Book noEJB = new Book("J2EE Development without EJB" , "3939459459" );
//        rod.getBooks().add(noEJB) ;
//        noEJB.getAuthors().add(rod) ;
//        noEJB.setPublisher(publisher) ;
//        publisher.getBooks().add(noEJB) ;
//        authorRepository.save(rod);
//        bookRepository.save(noEJB);
//        publisherRepository.save(publisher);
//
//        System.out.println( "Number of Books: " + bookRepository .count()) ;
//        System.out.println( "Publisher Number of Books: " + publisher.getBooks().size()) ;
    }
}