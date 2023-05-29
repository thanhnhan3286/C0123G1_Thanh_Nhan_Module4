package com.example.validatethongtinbaihat.controller;

import com.example.validatethongtinbaihat.dto.SongDTO;
import com.example.validatethongtinbaihat.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("list",songService.findAll());
        return "/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("songDTO", new SongDTO());
        return "/create";
    }
}
