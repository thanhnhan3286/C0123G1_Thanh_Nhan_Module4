package com.example.ungdungmuonsach.model;

import javax.persistence.*;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_book")
    private Book book;
    @Column(columnDefinition = "VARCHAR(5)",nullable = false)
    private String codeBorrow;

    public BorrowBook(Integer id, Book book, String codeBorrow) {
        this.id = id;
        this.book = book;
        this.codeBorrow = codeBorrow;
    }

    public BorrowBook(Book book, String codeBorrow) {
        this.book = book;
        this.codeBorrow = codeBorrow;
    }

    public BorrowBook() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCodeBorrow() {
        return codeBorrow;
    }

    public void setCodeBorrow(String codeBorrow) {
        this.codeBorrow = codeBorrow;
    }
}
