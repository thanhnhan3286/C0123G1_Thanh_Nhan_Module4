package com.example.validatethongtinbaihat.controller;

import com.example.validatethongtinbaihat.dto.SongDTO;
import com.example.validatethongtinbaihat.model.Song;
import com.example.validatethongtinbaihat.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
    public String list(Model model) {
        List<Song> listSong = songService.findAll();
        model.addAttribute("listSong", listSong);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("songDTO", new SongDTO());
        return "/create";
    }

    @PostMapping("/create")
    public String createPost(@Validated @ModelAttribute("songDTO") SongDTO songDTO, BindingResult bindingResult) {
        new SongDTO().validate(songDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDTO, song);
            songService.save(song);
            return "redirect:/";
        }
    }
}
