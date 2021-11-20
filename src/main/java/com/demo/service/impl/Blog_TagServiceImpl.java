package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.mapper.Blog_TagMapper;
import com.demo.dao.pojo.Blog_Tag;
import com.demo.service.Blog_TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Blog_TagServiceImpl extends ServiceImpl<Blog_TagMapper, Blog_Tag> implements Blog_TagService {
    @Autowired
    Blog_TagMapper blog_tagMapper;
    @Override
    public void deleteByBlogId(Long id) {
        blog_tagMapper.delete(new QueryWrapper<Blog_Tag>().eq("blog_id",id));
    }
}
