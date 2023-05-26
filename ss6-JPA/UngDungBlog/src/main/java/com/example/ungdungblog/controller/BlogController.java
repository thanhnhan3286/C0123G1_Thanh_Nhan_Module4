package com.example.ungdungblog.controller;

import com.example.ungdungblog.model.Blog;
import com.example.ungdungblog.model.Category;
import com.example.ungdungblog.service.IBlogService;
import com.example.ungdungblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        List<Blog> blogList = blogService.getAll();
        model.addAttribute("blogList", blogList);
        return "/list";
    }

    @GetMapping("/categoryList")
    public String homeCategory(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/listCategory";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @GetMapping("/createCategory")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/createCategory";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/createCategory")
    public String createCategoryPost(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/categoryList";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }
    @GetMapping("/{id}/editCategory")
    public String editCategory(Model model, @PathVariable int id){
        model.addAttribute("category",categoryService.findById(id));
        return "/editCategory";
    }
    @PostMapping("/edit")
    public String editPost(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }
    @PostMapping("/editCategory")
    public String editCategoryPost(Category category){
        this.categoryService.save(category);
        return "redirect:/categoryList";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int deleteId) {
        blogService.delete(deleteId);
        return "redirect:/";
    }
    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam int deleteId) {
        categoryService.delete(deleteId);
        return "redirect:/categoryList";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/detail";
    }

    @PostMapping("/search")
    public String search(@RequestParam String title, Model model) {
        List<Blog> blogList = blogService.findAllByTitleContaining(title);
        model.addAttribute("title", title);
        model.addAttribute("blogList", blogList);
        return "/list";
    }
}