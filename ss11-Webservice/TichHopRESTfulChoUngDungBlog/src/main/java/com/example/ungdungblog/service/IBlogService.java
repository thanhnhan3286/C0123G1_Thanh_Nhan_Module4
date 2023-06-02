package com.example.ungdungblog.service;

import com.example.ungdungblog.model.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    Page<Blog> getAll(int page);

    void save(Blog blog);

    Blog findById(int id);

    void delete(int deleteId);

    Page<Blog> findAllByTitleContaining(String title, int page);

    List<Blog> findAllByIdCategory(Integer id);
}
