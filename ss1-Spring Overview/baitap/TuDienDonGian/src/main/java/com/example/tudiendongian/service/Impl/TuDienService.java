package com.example.tudiendongian.service.Impl;

import com.example.tudiendongian.repository.ITuDienRepository;
import com.example.tudiendongian.service.ITuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TuDienService implements ITuDienService {
    @Autowired
    private ITuDienRepository tuDienRepository;
    @Override
    public String dich(String english) {
        Map<String,String> mapList = tuDienRepository.dich(english);
        String result = "'Chưa bổ sung từ này'";
        for (Map.Entry<String, String> m : mapList.entrySet()) {
            if (m.getKey().equals(english)){
                result = m.getValue();
            }
        }
        return result;
    }
}
