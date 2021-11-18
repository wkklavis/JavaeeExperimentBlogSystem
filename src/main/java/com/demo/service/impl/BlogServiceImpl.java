package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.dao.mapper.BlogTextMapper;
import com.demo.dao.mapper.BlogMapper;
import com.demo.dao.pojo.*;
import com.demo.service.BlogService;
import com.demo.service.BlogTextService;
import com.demo.service.Blog_TagService;
import com.demo.service.CommentService;
import com.demo.util.UserThreadLocal;
import com.demo.vo.ReturnResult;
import com.demo.vo.info.BlogInfo;
import com.demo.vo.info.BlogTextInfo;
import com.demo.vo.info.CommentInfo;
import com.demo.vo.info.TagInfo;
import com.demo.vo.param.BlogParam;
import com.demo.vo.param.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Transactional
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;
    @Autowired
    BlogTextService blogTextService;
    @Autowired
    CommentService commentService;
    @Autowired
    TagServiceImpl tagService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    MultiThreadService multiThreadService;
    @Autowired
    Blog_TagService blog_tagService;

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

    @Override
    public ReturnResult getBlogDetailById(Long id) {
        Blog blog = blogMapper.selectById(id);
        List<TagInfo> tagInfos = tagService.getTagsByBlogId(id);
        List<CommentInfo> commentInfos = commentService.getCommentsByBlogId(id);

        Instant instant = Instant.ofEpochMilli(blog.getCreateDate());
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime time =  LocalDateTime.ofInstant(instant, zone);
        BlogInfo blogInfo = new BlogInfo(blog.getId(),blog.getTitle(),blog.getDescription(),time,blog.getViews());
        BlogTextInfo blogTextInfo = blogTextService.getBlogTextByBlogId(id);
        User user = userService.getUserById(blog.getUserId());
        //设置文章作者
        blogInfo.setUser(user);
        //设置文章主体
        blogInfo.setText(blogTextInfo);
        //设置文章标签
        blogInfo.setTags(tagInfos);
        //设置文章评论
        blogInfo.setComments(commentInfos);
        blog.setViews(blog.getViews()+1);
        //异步线程更新数据，提升效率
        multiThreadService.updateBlog(blogMapper,blog);
        return ReturnResult.returnSuccess(blogInfo);
    }

    @Override
    public ReturnResult publishBlog(BlogParam blogParam) {
        User user = UserThreadLocal.get();
        Blog blog = new Blog();
        //保存blog
        blog.setUserId(user.getId());
        blog.setViews(0);
        blog.setCreateDate(System.currentTimeMillis());
        blog.setDescription(blogParam.getDescription());
        blog.setTitle(blogParam.getTitle());
        blogMapper.insert(blog);
        //保存blogtext
        BlogText blogText = new BlogText();
        blogText.setBlogId(blog.getId());
        blogText.setContent(blogParam.getText().getContent());
        blogText.setContentHtml(blogParam.getText().getContentHtml());
        blogTextService.save(blogText);
        //保存tags关系表
        List<Tag> tags = blogParam.getTags();
        for (Tag tag : tags) {
            Blog_Tag blog_tag = new Blog_Tag();
            blog_tag.setBlogId(blog.getId());
            blog_tag.setTagId(tag.getId());
            blog_tagService.save(blog_tag);
        }

        return ReturnResult.returnSuccess(new HashMap<String,Long>().put("id",blog.getId()));
    }
}
