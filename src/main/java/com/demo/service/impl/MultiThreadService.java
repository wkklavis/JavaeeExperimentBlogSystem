package com.demo.service.impl;

import com.demo.dao.mapper.BlogMapper;
import com.demo.dao.pojo.Blog;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MultiThreadService {
    @Async
    public void updateBlog(BlogMapper mapper, Blog blog){
        mapper.updateById(blog);
    }
}
