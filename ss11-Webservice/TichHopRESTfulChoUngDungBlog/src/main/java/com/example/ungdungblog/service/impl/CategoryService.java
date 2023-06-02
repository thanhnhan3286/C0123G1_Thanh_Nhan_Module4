package com.example.ungdungblog.service.impl;

import com.example.ungdungblog.model.Category;
import com.example.ungdungblog.repository.ICategoryRepository;
import com.example.ungdungblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAllByStatusIsFalse();
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void delete(int deleteId) {
        this.categoryRepository.setStatus(deleteId);
    }
}
