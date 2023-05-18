package com.example.ungdungchuyendoitiente.controller;

import com.example.ungdungchuyendoitiente.service.IChuyenDoiTienTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChuyenDoiTienTe {
    @Autowired
    private IChuyenDoiTienTeService chuyenDoiTienTeService;
    @GetMapping("/")
    public String chuyenDoiTienTe(Model model, @RequestParam(value = "usd", defaultValue = "0")float usd, @RequestParam(value = "vnd",defaultValue = "0")float vnd){
        long result = (long) chuyenDoiTienTeService.quyDoi(usd,vnd);
//        long result = Long.parseLong(String.valueOf(usd)) * Long.parseLong(String.valueOf(vnd));
        model.addAttribute("result",result);
        model.addAttribute("usd",usd);
        return "/chuyenDoiTienTe";
    }
}
