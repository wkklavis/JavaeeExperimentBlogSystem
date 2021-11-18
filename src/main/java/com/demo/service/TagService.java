package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.dao.pojo.Tag;
import com.demo.vo.ReturnResult;
import com.demo.vo.info.TagInfo;

import java.util.List;

public interface TagService extends IService<Tag> {
    public List<TagInfo> getTagsByBlogId(Long blodId);

    ReturnResult getAllTags();

}
