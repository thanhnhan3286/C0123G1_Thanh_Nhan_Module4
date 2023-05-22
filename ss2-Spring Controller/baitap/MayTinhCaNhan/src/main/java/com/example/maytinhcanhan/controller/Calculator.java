package com.example.maytinhcanhan.controller;

import com.example.maytinhcanhan.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class Calculator {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/")
    public String calculator(Model model, @RequestParam(value = "math", defaultValue = "add") String math, @RequestParam(value = "num1", defaultValue = "0") double num1,
                             @RequestParam(value = "num2", defaultValue = "0") double num2) {
        double result;
        String result1 = null;
        switch (math) {
            case "sub":
                result = iCalculatorService.subtraction(num1, num2);
                break;
            case "mul":
                result = iCalculatorService.multiplication(num1, num2);
                break;
            case "div":
                result = iCalculatorService.division(num1, num2);
                break;
            case "add":
                result = iCalculatorService.addition(num1, num2);
                break;
            default:
                result = 0;
                result1 = "Not exist!!!";
                break;
        }
        if (Objects.equals(math, "div") && num2 == 0) {
            result1 = "Not exist!!!";
        }
        model.addAttribute("result", result);
        model.addAttribute("result1", result1);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "index";
    }
}
