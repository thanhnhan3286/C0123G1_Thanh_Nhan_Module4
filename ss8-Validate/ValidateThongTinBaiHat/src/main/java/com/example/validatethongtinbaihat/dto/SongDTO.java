package com.example.validatethongtinbaihat.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class SongDTO implements Validator {
    private Integer id;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800,message = "Tên bài hát không được quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên bài hát không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String name;
    @NotBlank(message = "Tên nhạc sĩ không được để trống")
    @Size(max = 300,message = "Tên nhạc sĩ không được quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên nhạc sĩ không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String author;
    @NotBlank(message = "Tên ca sĩ không được để trống")
    @Size(max = 300,message = "Tên ca sĩ không được quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Tên ca sĩ không chứa các kí tự đặc biệt như @;,.=-+,...")
    private String singer;
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 1000,message = "Tên bài hát không được quá 1000 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$", message = "Thể loại không chứa các kí tự đặc biệt như @;.=-+,.... Nhưng cho dấu ','")
    private String type;
    public SongDTO() {
    }

    public SongDTO(String name, String author, String singer, String type) {
        this.name = name;
        this.author = author;
        this.singer = singer;
        this.type = type;
    }

    public SongDTO(Integer id, String name, String author, String singer, String type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.singer = singer;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
