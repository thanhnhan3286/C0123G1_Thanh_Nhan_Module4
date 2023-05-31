package com.example.ungdungmuonsach.repository;

import com.example.ungdungmuonsach.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Integer> {
}
