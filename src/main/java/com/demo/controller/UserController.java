package com.demo.controller;

import com.demo.service.UserService;
import com.demo.vo.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回json等内容到页面
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 根据头部token获取用户信息
     * @param token
     * @return
     */
    @PostMapping("currentUser")
    public ReturnResult currentUser(@RequestHeader("Authorization") String token){
        return userService.getUserByToken(token);
    }
}
