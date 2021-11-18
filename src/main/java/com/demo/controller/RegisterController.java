package com.demo.controller;

import com.demo.service.LoginService;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.RegisterParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回json等内容到页面
@RequestMapping("register")
public class RegisterController {
    @Autowired
    LoginService loginService;
    @PostMapping
    public ReturnResult register(@RequestBody RegisterParam registerParam){
        return loginService.register(registerParam);
    }
}
