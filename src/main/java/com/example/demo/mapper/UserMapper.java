package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int insert(User user);

    public int update(User user);

    public int delete(Long id);

    public List<User> select();
}
