package com.example.validateformdangky.controller;

import com.example.validateformdangky.dto.UserDTO;
import com.example.validateformdangky.model.User;
import com.example.validateformdangky.service.IUserService;
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
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/")
    public String create(Model model){
        model.addAttribute("userDTO",new UserDTO());
        return "/formDangKy";
    }
    @PostMapping("/create")
    public String createPost(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, Model model){
        new UserDTO().validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "/formDangKy";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            List<User> listEmail = userService.findByEmail(user.getEmail());
            List<User> listPhone = userService.findByPhone(user.getPhoneNumber());
            String emailIsExist= "Email đã tồn tại, hãy nhập e mail khác!!!";
            String phoneIsExist = "Số điện thoại đã tồn tại, hãy nhập số điện thoại khác!!!";
            if(listPhone.size()>0 && listEmail.size()>0){
                model.addAttribute("emailIsExist",emailIsExist);
                model.addAttribute("phoneIsExist",phoneIsExist);
                model.addAttribute("userDTO",userDTO);
                return "/formDangKy";
            }
            else if(listEmail.size() > 0){
                model.addAttribute("emailIsExist",emailIsExist);
                model.addAttribute("userDTO",userDTO);
                return "/formDangKy";
            }else if (listPhone.size() > 0){
                model.addAttribute("phoneIsExist",phoneIsExist);
                model.addAttribute("userDTO",userDTO);
                return "/formDangKy";
            }
            userService.save(user);
            return "/result";
        }
    }

}
