package com.example.ungdungblog.controller;

import com.example.ungdungblog.model.Blog;
import com.example.ungdungblog.model.Category;
import com.example.ungdungblog.service.IBlogService;
import com.example.ungdungblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blog")
public class BlogRESTController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/blogList")
    public ResponseEntity<List<Blog>> getListBlog(){
        return new ResponseEntity<>(blogService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Blog>> getListBlogByCategory(@PathVariable("categoryId") Integer categoryId){
        return new ResponseEntity<>(blogService.findAllByIdCategory(categoryId),HttpStatus.OK);
    }
    @GetMapping("/blogDetail/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Integer id){
        return new ResponseEntity<>(blogService.findById(id),HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlogByTitle(@RequestParam("title") String title){
        List<Blog> blogList = blogService.findAllByTitle(title);
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
}
