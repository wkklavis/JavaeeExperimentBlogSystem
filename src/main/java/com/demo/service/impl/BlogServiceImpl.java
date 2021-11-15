package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dao.mapper.BlogMapper;
import com.demo.dao.pojo.Blog;
import com.demo.service.BlogService;
import com.demo.vo.ReturnResult;
import com.demo.vo.info.BlogInfo;
import com.demo.vo.param.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    TagServiceImpl tagService;
    @Autowired
    UserServiceImpl userService;

    /**
     * 根据页参数，返回分页博客
     * @param pageParam
     * @return
     */
    @Override
    public ReturnResult getBlogsByPage(PageParam pageParam) {
        //取页
        Page<Blog> page = new Page<>(pageParam.getPage(),pageParam.getPageSize());
        IPage<Blog> articleIPage = blogMapper.selectPage(
                page, new QueryWrapper<Blog>().orderByDesc("create_date"));
        //封装成前端数据返回
        List<Blog> blogs = articleIPage.getRecords();
        List<BlogInfo> blogInfos = new ArrayList<>();

        for (Blog blog : blogs) {
            Instant instant = Instant.ofEpochMilli(blog.getCreateDate());
            ZoneId zone = ZoneId.systemDefault();
            LocalDateTime time =  LocalDateTime.ofInstant(instant, zone);
            BlogInfo blogInfo = new BlogInfo(blog.getId(),blog.getTitle(),blog.getDescription(),
                                            time,blog.getViews());
            blogInfo.setUserNickname(userService.getUserById(blog.getUserId()).getNickname());
            blogInfo.setTags(tagService.getTagsByBlogId(blog.getId()));
            blogInfos.add(blogInfo);
        }
        return ReturnResult.returnSuccess(blogInfos);
    }
}
