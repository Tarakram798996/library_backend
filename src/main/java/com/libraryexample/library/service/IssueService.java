package com.libraryexample.library.service;

import com.libraryexample.library.model.Issue;
import com.libraryexample.library.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public Issue issueBook(Issue issue) {
        issue.setIssueDate(LocalDateTime.now());
        return issueRepository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue getIssueById(int id) {
        return issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue with ID " + id + " not found"));
    }

    public Issue returnBook(int id, LocalDate returnDate) {
        Issue issue = issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue with ID " + id + " not found"));
        issue.setReturnDate(returnDate);
        return issueRepository.save(issue);
    }

    public void deleteIssueById(int id) {
        if (!issueRepository.existsById(id)) {
            throw new RuntimeException("Issue with ID " + id + " not found");
        }
        issueRepository.deleteById(id);
    }
}
