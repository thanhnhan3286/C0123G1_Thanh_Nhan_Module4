package com.example.ungdungmuonsach.service.impl;

import com.example.ungdungmuonsach.model.Book;
import com.example.ungdungmuonsach.repository.IBookRepository;
import com.example.ungdungmuonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public String ramdomCodeBorrow() {
        Random random = new Random();
        int code = random.nextInt(90000) + 10000;
        String codeBorrow = String.valueOf(code);
        return codeBorrow;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void saveBook(Book book) {
        int quantity = book.getQuantity() - 1;
        book.setQuantity(quantity);
        bookRepository.save(book);
    }

//    @Override
//    public void setQuantity(int id) {
//        this.bookRepository.setQuantity(id);
//    }
}
