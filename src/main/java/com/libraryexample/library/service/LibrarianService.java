package com.libraryexample.library.service;

import com.libraryexample.library.model.Librarian;
import com.libraryexample.library.repository.LibrarianRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {

    @Autowired
    LibrarianRepository librarianRepository;

    public List<Librarian> getAll() {
        return librarianRepository.findAll();
    }

    public Librarian save(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public Librarian getById(int id) {
        return librarianRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not Found"));
    }

    @Transactional
    public Librarian updateLib(int id, Librarian lib) {
        Librarian curLib = librarianRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Not Found"));
        curLib.setEmail(lib.getEmail());
        curLib.setName(lib.getName());
        curLib.setUsername(lib.getUsername());
        curLib.setPassword(lib.getPassword());

        return librarianRepository.save(curLib);
    }

    public void deleteById(int id) {
        if (!librarianRepository.existsById(id)) {
            throw new RuntimeException("Librarian with ID " + id + " not found");
        }
        librarianRepository.deleteById(id);
    }
}
