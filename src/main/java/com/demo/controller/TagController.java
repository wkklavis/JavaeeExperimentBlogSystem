package com.demo.controller;

import com.demo.service.TagService;
import com.demo.vo.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//返回json等内容到页面
@RequestMapping("tag")
public class TagController {
    @Autowired
    TagService tagService;
    @GetMapping("/alltags")
    public ReturnResult getAllTags(){
        return tagService.getAllTags();
    }
}
