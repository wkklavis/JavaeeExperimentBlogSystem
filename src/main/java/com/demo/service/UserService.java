package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.dao.pojo.User;
import com.demo.vo.ReturnResult;

public interface UserService extends IService<User> {
    public User getUserById(Long userId);

    User getUserByUsernameAndPassword(String username, String password);

    ReturnResult getUserByToken(String token);
}
