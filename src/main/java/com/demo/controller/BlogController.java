package com.demo.controller;

import com.demo.dao.pojo.Blog;
import com.demo.service.BlogService;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.BlogParam;
import com.demo.vo.param.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//返回json等内容到页面
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;
    //博客取页查询
    @PostMapping
    public ReturnResult getBlogsByPage(@RequestBody PageParam param){
        return blogService.getBlogsByPage(param);
    }
/*    @PostMapping("/{id}")
    public ReturnResult getBlogById(@PathVariable("id")Long id){
        return blogService.getBlogDetailById(id);
    }*/
    @PostMapping("/detail/{id}")
    public ReturnResult getBlogDetailById(@PathVariable("id")Long id){
        return blogService.getBlogDetailById(id);
    }
    @PostMapping("/publish")
    public ReturnResult publishBlog(@RequestBody BlogParam blogParam){
        return blogService.publishBlog(blogParam);
    }
    //根据tagId查询所有含tag的文章
    @PostMapping("/withtag/{id}")
    public ReturnResult getBlogsByTag(@PathVariable("id")Long tagId){
        return blogService.getBlogsByTag(tagId);
    }
    @PostMapping("query/{key}")
    public ReturnResult getBlogsByQueryKey(@PathVariable("key")String key){
        return blogService.getBlogsByQueryKey(key);
    }
    @PostMapping("/delete/{id}")
    public ReturnResult deleteBlogById(@PathVariable("id")Long id){
        return blogService.deleteBlogById(id);
    }
    @PostMapping("/save")
    public ReturnResult saveBlog(@RequestBody BlogParam blogParam){
        return blogService.saveBlog(blogParam);
    }
}
