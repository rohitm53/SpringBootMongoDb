package com.rohit.mongo.controller;

import com.rohit.mongo.model.Book;
import com.rohit.mongo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addbook")
    @CachePut(value = "book",key = "#book.id")
    @ResponseBody
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("/getall")
    @Cacheable(value = "book")
    @ResponseBody
    public Iterable<Book> getAllBook(){
        return bookService.getALlBook();
    }

    @GetMapping("/get/{id}")
    @Cacheable(value = "book",key = "#id")
    @ResponseBody
    public Book getBookById(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    @PutMapping("/update")
    @CachePut(value = "book",key = "#book.id")
    @ResponseBody
    public Book updateBoook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    @CacheEvict(value = "book",key = "#id")
    @ResponseBody
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "Succesfully Deleted book with id : "+id;
    }

    @DeleteMapping("/deleteall")
    @CacheEvict(value = "book",allEntries = true)
    @ResponseBody
    public String deleteAll(){
        bookService.deleteAllBooks();
        return "Succesfully all books";
    }

    @DeleteMapping("/clearcache")
    @CacheEvict(value = "book",allEntries = true)
    @ResponseBody
    public String clearCache(){
        return "Cache cleared";
    }
}
