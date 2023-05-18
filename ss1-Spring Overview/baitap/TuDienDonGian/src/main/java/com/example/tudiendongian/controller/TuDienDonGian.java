package com.example.tudiendongian.controller;

import com.example.tudiendongian.service.ITuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TuDienDonGian {
    @Autowired
    private ITuDienService tuDienService;
    @GetMapping("/")
    public String tuDien(){
        return "/tuDien";
    }

    @PostMapping("/")
    public String tuDien(Model model, @RequestParam(value = "english") String english) {
        String result = tuDienService.dich(english);
        model.addAttribute("result", result);
        model.addAttribute("english", english);
        return "/tuDien";
    }

}
