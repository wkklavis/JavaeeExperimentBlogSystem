package com.demo.service;

import com.demo.vo.info.TagInfo;

import java.util.List;

public interface TagService {
    public List<TagInfo> getTagsByBlogId(Long blodId);
}
