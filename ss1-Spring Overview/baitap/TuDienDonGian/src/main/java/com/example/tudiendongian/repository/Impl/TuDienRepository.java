package com.example.tudiendongian.repository.Impl;

import com.example.tudiendongian.repository.ITuDienRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TuDienRepository implements ITuDienRepository {
    private static Map<String, String> mapList = new HashMap<>();

    static {
        mapList.put("english", "tiếng anh");
        mapList.put("one", "số một");
        mapList.put("two", "số hai");
        mapList.put("three", "số ba");
        mapList.put("four", "số bốn");
        mapList.put("five", "số năm");
    }

    @Override
    public Map<String,String> dich(String english) {
//        String result = "Không dịch được";
//        for (Map.Entry<String, String> m : mapList.entrySet()) {
//            if (m.getKey().equals(english)){
//                result = m.getValue();
//            }
//        }
        return mapList;
    }
}
