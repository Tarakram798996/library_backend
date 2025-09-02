package com.libraryexample.library.repository;

import com.libraryexample.library.model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {
}
