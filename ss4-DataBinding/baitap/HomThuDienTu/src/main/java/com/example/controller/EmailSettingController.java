package com.example.controller;

import com.example.model.EmailSettings;
import com.example.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailSettingController {
    @Autowired
    private IEmailSettingService iEmailSettingService;
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/setting")
    public String setting (Model model){
        String[] languages = {"English","Vietnamese","Japanese","Chinese"};
        Integer[] pageSizes = {5,10,15,20,25,50,100};
        EmailSettings emailSettings =  iEmailSettingService.getAll();
        model.addAttribute("languages",languages);
        model.addAttribute("pageSize",pageSizes);
        model.addAttribute("emailSettings",emailSettings);
        return "update";
    }
    @PostMapping("/update")
    public String update (@ModelAttribute("emailSettings") EmailSettings emailSettings, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        iEmailSettingService.save(emailSettings);
        return "index";
    }
}
