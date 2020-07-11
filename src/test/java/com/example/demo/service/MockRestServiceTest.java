package com.example.demo.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
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

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

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

    @Test
    public void request4() {
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any())).thenThrow(new RestClientException("test"));
        try {
            restService.request();
        } catch (RuntimeException e) {
            assertEquals("test", e.getMessage());
        }
    }
}