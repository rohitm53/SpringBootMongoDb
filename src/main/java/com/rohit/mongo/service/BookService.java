package com.rohit.mongo.service;

import com.rohit.mongo.model.Book;
import com.rohit.mongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book){
        System.out.println("Calling saveBook");
        return bookRepository.save(book);
    }

    public Iterable<Book> getALlBook(){
        System.out.println("Calling getALlBook");
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        System.out.println("Calling getBookById");
        return bookRepository.findById(id).get();
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(int id){
        System.out.println("Calling deleteBookById");
        bookRepository.deleteById(id);
    }
    public void deleteAllBooks(){
        System.out.println("Calling deleteAllBooks");
        bookRepository.deleteAll();
    }
}
