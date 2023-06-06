package com.example.ungdungblog.service.impl;

import com.example.ungdungblog.model.Blog;
import com.example.ungdungblog.repository.IBlogRepository;
import com.example.ungdungblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
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

    @Override
    public List<Blog> findAllByTitle(String title) {
        return blogRepository.findAllByTitle(title);
    }



    @Override
    public Page<Blog> getAllBlog() {
        return blogRepository.findAll(PageRequest.of(0,2));
    }

    @Override
    public List<Blog> loadMore(Integer number) {
        List<Blog> blogList = blogRepository.findAll();
        List<Blog> blogs = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < blogList.size(); i++) {
            if (i >= (number - 1) * 2) {
                blogs.add(j, blogList.get(i));
                j++;
            }
        }
        return blogs;
    }

    @Override
    public Page<Blog> findAllBlogBySlice(Integer page) {
//        return blogRepository.findAll(PageRequest.of(page,2));
        return blogRepository.findAllByStatusIsFalse(PageRequest.of(page,2));
    }
}
