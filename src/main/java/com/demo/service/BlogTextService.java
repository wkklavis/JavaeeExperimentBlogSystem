package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.dao.pojo.BlogText;
import com.demo.vo.info.BlogTextInfo;

public interface BlogTextService extends IService<BlogText> {
    public BlogTextInfo getBlogTextByBlogId(Long blogId);

    void deleteByBlogId(Long id);
}
