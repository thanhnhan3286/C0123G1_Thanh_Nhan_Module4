package com.example.ungdungmuonsach.repository;

import com.example.ungdungmuonsach.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Integer> {
    @Query(value = "SELECT * FROM borrow_book WHERE code_borrow = :codeBorrow",nativeQuery = true)
    List<BorrowBook> findAllByCodeBorrow(@Param("codeBorrow") String codeBorrow);
    @Query(value = "SELECT * FROM borrow_book WHERE code_borrow = :codeBorrow",nativeQuery = true)
    BorrowBook findByCodeBorrow(@Param("codeBorrow")String codeBorrow);
}
