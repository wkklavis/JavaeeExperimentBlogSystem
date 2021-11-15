package com.demo.service;

import com.demo.vo.ReturnResult;
import com.demo.vo.param.PageParam;

public interface BlogService {
    public ReturnResult getBlogsByPage(PageParam param);
}
