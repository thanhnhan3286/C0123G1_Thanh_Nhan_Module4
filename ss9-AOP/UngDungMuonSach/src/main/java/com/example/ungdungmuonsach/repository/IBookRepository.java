package com.example.ungdungmuonsach.repository;

import com.example.ungdungmuonsach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}
