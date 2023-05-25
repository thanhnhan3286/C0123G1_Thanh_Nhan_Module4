package com.example.ungdungblog.controller;

import com.example.ungdungblog.model.Blog;
import com.example.ungdungblog.service.IBlogService;
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

    @GetMapping("/")
    public String home(Model model) {
        List<Blog> blogList = blogService.getAll();
        model.addAttribute("blogList", blogList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute("blog") Blog blog, Model model, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editPost(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int deleteId) {
        blogService.delete(deleteId);
        return "redirect:/";
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
