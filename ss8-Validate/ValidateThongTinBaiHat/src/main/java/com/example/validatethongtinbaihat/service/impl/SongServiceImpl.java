package com.example.validatethongtinbaihat.service.impl;

import com.example.validatethongtinbaihat.model.Song;
import com.example.validatethongtinbaihat.repository.ISongRepository;
import com.example.validatethongtinbaihat.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.songRepository.save(song);
    }
}
