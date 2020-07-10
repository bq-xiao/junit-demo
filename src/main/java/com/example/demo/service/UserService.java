package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String insert(User user) {
        int result = userMapper.insert(user);
        if (result > 0) {
            return "add succes";
        } else {
            return "add failed";
        }
    }
}
