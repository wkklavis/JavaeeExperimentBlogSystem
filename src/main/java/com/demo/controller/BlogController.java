package com.demo.controller;

import com.demo.service.BlogService;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回json等内容到页面
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ReturnResult getBlogsByPage(@RequestBody PageParam param){
        return blogService.getBlogsByPage(param);
    }
}
