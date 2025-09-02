package com.libraryexample.library.controller;


import com.libraryexample.library.model.Book;
import com.libraryexample.library.model.Librarian;
import com.libraryexample.library.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarians")
public class LibrarianController {

    @Autowired
    LibrarianService librarianService;

    @GetMapping
    public List<Librarian> getAllLibrarian(){
        return librarianService.getAll();
    }

    @PostMapping
    public ResponseEntity<Librarian> createLibrarian(@RequestBody Librarian librarian){
        Librarian savedLib = librarianService.save(librarian);
        return new ResponseEntity<>(savedLib, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Librarian> getLibrarianById(@PathVariable int id){
        Librarian lib = librarianService.getById(id);
        return new ResponseEntity<>(lib,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Librarian> updateLibrarian(@PathVariable int id,@RequestBody Librarian lib){
        Librarian updatedLib = librarianService.updateLib(id,lib);
        return new ResponseEntity<>(updatedLib,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteLibrarian(@PathVariable int id){
        librarianService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
