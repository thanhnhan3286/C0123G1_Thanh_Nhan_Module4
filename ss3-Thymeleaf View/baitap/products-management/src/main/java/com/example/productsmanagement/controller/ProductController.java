package com.example.productsmanagement.controller;

import com.example.productsmanagement.model.Product;
import com.example.productsmanagement.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/")
    public String listProduct(Model model){
        List<Product> productList = productService.getList();
        model.addAttribute("products", productList);
        return "list";

    }@GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String createPost(Product product){
        productService.add(product);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String editPost(Product product){
        productService.update(product);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer deleteId){
        productService.delete(deleteId);
        return "redirect:/";
    }
    @GetMapping("/{id}/detail")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/detail";
    }
    @PostMapping("/search")
    public String searchByName(@RequestParam String name, Model model){
        model.addAttribute("products", productService.findByName(name));
        return "/list";
    }
}
