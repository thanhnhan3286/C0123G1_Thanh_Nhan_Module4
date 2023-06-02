package com.example.ungdungblog.service.impl;

import com.example.ungdungblog.model.Blog;
import com.example.ungdungblog.repository.IBlogRepository;
import com.example.ungdungblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }
    @Override
    public Page<Blog> getAll(int page){
        return blogRepository.findAllByStatusIsFalse(PageRequest.of(page,4));
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void delete(int deleteId) {
        this.blogRepository.setStatus(deleteId);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, int page) {
        return blogRepository.findAllByTitleContainingAndStatusIsFalse(title, PageRequest.of(page,4));
    }

    @Override
    public List<Blog> findAllByIdCategory(Integer id) {
        return blogRepository.findAllByIdCategory(id);
    }
}
