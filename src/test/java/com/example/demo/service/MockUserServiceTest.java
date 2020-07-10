package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MockUserServiceTest {
    @Autowired
    @InjectMocks
    private UserService userService;
    @MockBean
    private UserMapper userMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void insert1() {
        User user = new User();
        Mockito.when(userMapper.insert(Mockito.any())).thenReturn(1);
        String result = userService.insert(user);
        assertEquals("add succes", result);
    }

    @Test
    public void insert2() {
        User user = new User();
        Mockito.when(userMapper.insert(Mockito.any())).thenReturn(0);
        String result = userService.insert(user);
        assertEquals("add failed", result);
    }

    @Test(expected = RuntimeException.class)
    public void insert3() {
        User user = new User();
        Mockito.when(userMapper.insert(Mockito.any())).thenThrow(RuntimeException.class);
        userService.insert(user);
    }
}