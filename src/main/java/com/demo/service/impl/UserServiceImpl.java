package com.demo.service.impl;

import com.demo.dao.mapper.UserMapper;
import com.demo.dao.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }
}
