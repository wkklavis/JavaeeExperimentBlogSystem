package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.dao.pojo.User;
import com.demo.vo.ReturnResult;

public interface UserService extends IService<User> {
    public User getUserById(Long userId);

    User getUserByUsername(String username);

    ReturnResult getUserByToken(String token);

    ReturnResult deleteUserById(Long id);
}
