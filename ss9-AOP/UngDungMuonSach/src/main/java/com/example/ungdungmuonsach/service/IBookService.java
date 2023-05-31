package com.example.ungdungmuonsach.service;

import com.example.ungdungmuonsach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    String ramdomCodeBorrow();

    Book findById(int id);

//    void setQuantity(int id);

    void saveBookBorrow(Book book);

    void saveBookReturn(Book book);
}
