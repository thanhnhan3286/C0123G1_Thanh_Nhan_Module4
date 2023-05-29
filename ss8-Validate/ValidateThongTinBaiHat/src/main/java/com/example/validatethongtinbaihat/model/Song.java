package com.example.validatethongtinbaihat.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String author;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String singer;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String type;
    public Song() {
    }

    public Song(String name, String author, String singer, String type) {
        this.name = name;
        this.author = author;
        this.singer = singer;
        this.type = type;
    }

    public Song(Integer id, String name, String author, String singer, String type) {
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
}
