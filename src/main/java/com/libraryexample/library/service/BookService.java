package com.libraryexample.library.service;

import com.libraryexample.library.model.Book;
import com.libraryexample.library.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAll() {

        List<Book> books= bookRepository.findAll();

        return books;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book getById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    @Transactional
    public Book updateBook(int id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPublisher(updatedBook.getPublisher());
        existingBook.setYear(updatedBook.getYear());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setTotalCopies(updatedBook.getTotalCopies());
        existingBook.setAvailableCopies(updatedBook.getAvailableCopies());

        return bookRepository.save(existingBook);
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
