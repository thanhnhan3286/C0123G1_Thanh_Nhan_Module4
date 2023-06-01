package com.example.giohang.controller;

import com.example.giohang.model.Products;
import com.example.giohang.service.ICartService;
import com.example.giohang.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
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
        model.addAttribute("listProduct",productsList);
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
        Products flower = productsService.findById(id);
        if (!cartService.checkExist(flower, productList)) {
            productList.put(flower, 1);
        } else {
            Map.Entry<Products,Integer> m = cartService.productIntegerEntry(flower,productList);

            Integer quantity = m.getValue() + 1;
            productList.replace(m.getKey(),quantity);
        }
        redirectAttributes.addFlashAttribute("mess", "ADDED");

        return "redirect:/";
    }
}
