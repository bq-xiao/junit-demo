package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {
    @Autowired
    private RestTemplate restTemplate;

    public String request() {
        String resp = restTemplate.getForObject("http://www.baidu.com", String.class);
        if (!StringUtils.isEmpty(resp)) {
            return "success";
        } else {
            return "failed";
        }
    }
}
