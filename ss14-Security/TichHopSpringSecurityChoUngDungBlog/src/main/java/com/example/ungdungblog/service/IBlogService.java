package com.example.ungdungblog.service;

import com.example.ungdungblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import java.awt.print.Pageable;
import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    Page<Blog> getAll(int page);

    void save(Blog blog);

    Blog findById(int id);

    void delete(int deleteId);

    Page<Blog> findAllByTitleContaining(String title, int page);

    List<Blog> findAllByIdCategory(Integer id);

    List<Blog> findAllByTitle(String title);

    Page<Blog> getAllBlog();

    List<Blog> loadMore(Integer number);

    Page<Blog> findAllBlogBySlice(Integer page);
}
