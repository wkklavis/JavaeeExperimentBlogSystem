package com.demo.controller;

import com.demo.service.BlogService;
import com.demo.service.CommentService;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.CommentParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//返回json等内容到页面
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ReturnResult addComment(@RequestBody CommentParam commentParam){
        return commentService.addComment(commentParam);
    }

    @PostMapping("/delete/{id}")
    public ReturnResult deleteComment(@PathVariable("id")Long commentId){
        return commentService.deleteComment(commentId);
    }
}
