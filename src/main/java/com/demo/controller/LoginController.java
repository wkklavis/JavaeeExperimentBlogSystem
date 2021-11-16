package com.demo.controller;

import com.demo.service.LoginService;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.LoginParam;
import com.demo.vo.param.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回json等内容到页面
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping
    public ReturnResult login(@RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }
}
