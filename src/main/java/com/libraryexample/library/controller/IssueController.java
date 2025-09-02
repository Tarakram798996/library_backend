package com.libraryexample.library.controller;

import com.libraryexample.library.model.Issue;
import com.libraryexample.library.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody Issue issue) {
        Issue savedIssue = issueService.issueBook(issue);
        return new ResponseEntity<>(savedIssue, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Issue> getAllIssues() {
        return issueService.getAllIssues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable int id) {
        Issue issue = issueService.getIssueById(id);
        return new ResponseEntity<>(issue, HttpStatus.OK);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Issue> returnBook(@PathVariable int id, @RequestBody Issue updatedIssue) {
        Issue returned = issueService.returnBook(id, updatedIssue.getReturnDate());
        return new ResponseEntity<>(returned, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssue(@PathVariable int id) {
        issueService.deleteIssueById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
