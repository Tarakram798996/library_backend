package com.libraryexample.library.controller;

import com.libraryexample.library.model.Book;
import com.libraryexample.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAll();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book savedBook = bookService.save(book);
        return new ResponseEntity<>(savedBook,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
        Book book = bookService.getById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book){
        Book updatedBook = bookService.updateBook(id,book);
        return new ResponseEntity<>(updatedBook,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
        bookService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
