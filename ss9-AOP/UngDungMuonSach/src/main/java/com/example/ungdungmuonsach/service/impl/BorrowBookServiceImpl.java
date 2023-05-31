package com.example.ungdungmuonsach.service.impl;

import com.example.ungdungmuonsach.model.BorrowBook;
import com.example.ungdungmuonsach.repository.IBorrowBookRepository;
import com.example.ungdungmuonsach.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookServiceImpl implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository borrowBookRepository;
    @Override
    public List<BorrowBook> findAll() {
        return borrowBookRepository.findAll();
    }

    @Override
    public void save(BorrowBook borrowBook) {
        this.borrowBookRepository.save(borrowBook);
    }

    @Override
    public boolean findAllByCodeBorrow(String codeBorrow) {
        List<BorrowBook> borrowBooks = borrowBookRepository.findAllByCodeBorrow(codeBorrow);
        return borrowBooks.size() == 1;
    }

    @Override
    public BorrowBook findByCodeBorrow(String codeBorrow) {
        return borrowBookRepository.findByCodeBorrow(codeBorrow);
    }

    @Override
    public void delete(BorrowBook borrowBook) {
        this.borrowBookRepository.delete(borrowBook);
    }
}
