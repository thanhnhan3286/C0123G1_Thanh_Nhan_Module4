package com.example.ungdungmuonsach.service;

import com.example.ungdungmuonsach.model.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> findAll();

    void save(BorrowBook borrowBook);
}
