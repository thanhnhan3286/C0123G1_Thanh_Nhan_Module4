package com.example.giohang.controller;

import com.example.giohang.model.Products;
import com.example.giohang.service.ICartService;
import com.example.giohang.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@SessionAttributes("/cart")
public class ShoppingCartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IProductsService productsService;
    @GetMapping("/cart")
    public String carts(@SessionAttribute("cart") Map<Products,Integer> list , Model model){
        model.addAttribute("cart",list);
        double total = cartService.getTotal(list);
        model.addAttribute("total", total);
        return "/cart";
    }
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes,
                      @ModelAttribute("cart") Map<Products, Integer> productList) {
        Products products = productsService.findById(id);
        if (!cartService.checkExist(products, productList)) {
            productList.put(products, 1);
        } else {
            Map.Entry<Products,Integer> m = cartService.productIntegerEntry(products,productList);
            Integer quantity = m.getValue() + 1;
            productList.replace(m.getKey(),quantity);
        }
        redirectAttributes.addFlashAttribute("mess", "ADDED");
        return "redirect:/cart";
    }
    @GetMapping("/remove/{id}")
    public String removeToCart(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes,
                               @ModelAttribute("cart") Map<Products, Integer> productList) {
        Products products = productsService.findById(id);
        Integer quantity;
        if (!cartService.checkExist(products, productList)) {
            productList.put(products, 1);
        } else {
            Map.Entry<Products,Integer> m = cartService.productIntegerEntry(products,productList);
            quantity = m.getValue() - 1;
            productList.replace(m.getKey(),quantity);
            if (m.getValue()==0){
                productList.remove(m.getKey());
            }
        }
        return "redirect:/cart";
    }
}
