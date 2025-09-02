package com.libraryexample.library.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IssueID")
    private int issueId;

    @ManyToOne
    @JoinColumn(name = "BookID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "MemberID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "IssuedBy")
    private Librarian issuedBy;

    @Column(name = "IssueDate")
    private LocalDateTime issueDate;

    @Column(name = "DueDate")
    private LocalDate dueDate;

    @Column(name = "ReturnDate")
    private LocalDate returnDate;

    // Getters and Setters

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Librarian getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(Librarian issuedBy) {
        this.issuedBy = issuedBy;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
