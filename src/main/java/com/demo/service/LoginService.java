package com.demo.service;

import com.demo.dao.pojo.User;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.LoginParam;

public interface LoginService {
    public ReturnResult login(LoginParam loginParam);

    public User pasreToken(String token);

    public ReturnResult logout(String token);
}
