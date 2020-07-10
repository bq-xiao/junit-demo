package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MockRestServiceTest {
    @Autowired
    @InjectMocks
    private RestService restService;
    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void request1() {
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenReturn("test");
        String result = restService.request();
        assertEquals("success", result);
    }

    @Test
    public void request2() {
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenReturn(null);
        String result = restService.request();
        assertEquals("failed", result);
    }

    @Test(expected = RuntimeException.class)
    public void request3() {
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenThrow(RuntimeException.class);
        restService.request();
    }
}