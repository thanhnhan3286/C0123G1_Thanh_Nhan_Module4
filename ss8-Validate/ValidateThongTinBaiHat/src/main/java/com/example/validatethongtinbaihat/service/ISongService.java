package com.example.validatethongtinbaihat.service;

import com.example.validatethongtinbaihat.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);
}
