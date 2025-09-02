package com.libraryexample.library.repository;

import com.libraryexample.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {

}
