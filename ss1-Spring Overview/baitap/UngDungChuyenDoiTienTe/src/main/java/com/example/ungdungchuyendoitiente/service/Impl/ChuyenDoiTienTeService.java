package com.example.ungdungchuyendoitiente.service.Impl;

import com.example.ungdungchuyendoitiente.service.IChuyenDoiTienTeService;
import org.springframework.stereotype.Service;

@Service
public class ChuyenDoiTienTeService implements IChuyenDoiTienTeService {
    @Override
    public float quyDoi(float usd, float vnd) {
        return usd * vnd;
    }
}
