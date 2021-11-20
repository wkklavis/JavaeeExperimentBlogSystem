package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.dao.pojo.Blog_Tag;

public interface Blog_TagService extends IService<Blog_Tag> {
    void deleteByBlogId(Long id);
}
