package com.example.giohang.controller;

import com.example.giohang.model.Products;
import com.example.giohang.service.ICartService;
import com.example.giohang.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductsController {
    @Autowired
    private IProductsService productsService;
    @Autowired
    private ICartService cartService;
    @GetMapping("/")
    public String list(Model model){
        List<Products> productsList = productsService.findAll();
        model.addAttribute("productsList",productsList);
        return "/listProduct";
    }
    @ModelAttribute("cart")
    public Map<Products,Integer> initCart(){
        return new LinkedHashMap<>();
    }
    @GetMapping("/{id}/detail")
    public String detail(Model model, @PathVariable int id){
        Products products = productsService.findById(id);
        model.addAttribute("product",products);
        return "/detail";
    }
    @GetMapping("/{id}/addToCart")
    public String addToCart(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes,
                            @ModelAttribute("cart") Map<Products, Integer> productList) {
        Products products = productsService.findById(id);
        this.cartService.addProduct(products,productList);
        return "redirect:/cart";
    }
    @GetMapping("/{id}/remove")
    public String removeToCart(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes,
                               @ModelAttribute("cart") Map<Products, Integer> productList) {
        Products products = productsService.findById(id);
        this.cartService.removeProduct(products,productList);
        return "redirect:/cart";
    }
    @GetMapping("/cart")
    public String carts(@SessionAttribute("cart") Map<Products,Integer> list , Model model){
        model.addAttribute("cart",list);
        double total = cartService.countTotalPayment(list);
        model.addAttribute("total", total);
        return "/cart";
    }
}
