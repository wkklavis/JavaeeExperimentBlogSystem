package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.dao.pojo.Blog;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.BlogParam;
import com.demo.vo.param.PageParam;

public interface BlogService extends IService<Blog> {
    public ReturnResult getBlogsByPage(PageParam param);

    ReturnResult getBlogDetailById(Long id);

    ReturnResult publishBlog(BlogParam blogParam);

    ReturnResult getBlogsByTag(Long tagId);

    ReturnResult getBlogsByQueryKey(String key);

    ReturnResult deleteBlogById(Long id);

    void deleteBlogByUserId(Long userId);
}
