package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.mapper.BlogMapper;
import com.demo.dao.mapper.BlogTextMapper;
import com.demo.dao.pojo.BlogText;
import com.demo.dao.pojo.Comment;
import com.demo.service.BlogService;
import com.demo.service.BlogTextService;
import com.demo.vo.info.BlogTextInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class BlogTextServiceImpl extends ServiceImpl<BlogTextMapper, BlogText> implements BlogTextService {
    @Autowired
    BlogTextMapper blogTextMapper;
    @Override
    public BlogTextInfo getBlogTextByBlogId(Long blogId) {
        QueryWrapper<BlogText> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("blog_id",blogId);
        queryWrapper.select("id","content","content_html");
        BlogText blogText = blogTextMapper.selectOne(queryWrapper);
        BlogTextInfo blogTextInfo = new BlogTextInfo();
        blogTextInfo.setId(blogText.getId());
        blogTextInfo.setContent(blogText.getContent());
        blogTextInfo.setContentHtml(blogText.getContentHtml());
        return blogTextInfo;
    }
}
