package com.example.demo.service;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Disabled
public class RestServiceTest {
    @Autowired
    private RestService restService;

    @Test
    public void request1() {
        String result = restService.request();
        assertEquals("success", result);
    }
}