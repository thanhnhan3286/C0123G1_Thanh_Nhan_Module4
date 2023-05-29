package com.example.validatethongtinbaihat.repository;

import com.example.validatethongtinbaihat.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
