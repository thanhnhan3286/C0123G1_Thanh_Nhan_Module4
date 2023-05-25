package com.example.ungdungblog.service;

import com.example.ungdungblog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    void save(Blog blog);

    Blog findById(int id);

    void delete(int deleteId);

    List<Blog> findAllByTitleContaining(String title);
}
