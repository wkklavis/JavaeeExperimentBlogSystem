package com.demo.controller;

import com.demo.service.UserService;
import com.demo.vo.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete/{id}")
    public ReturnResult deleteUserById(@PathVariable("id")Long id){
        return userService.deleteUserById(id);
    }
}
