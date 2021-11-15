package com.demo.service.impl;

import com.demo.dao.mapper.TagMapper;
import com.demo.dao.pojo.Tag;
import com.demo.service.TagService;
import com.demo.vo.info.TagInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    public List<TagInfo> getTagsByBlogId(Long blodId){
        List<Tag> tags = tagMapper.getTagsByBlogId(blodId);
        List<TagInfo> tagInfos = new ArrayList<>();
        tags.forEach(tag -> tagInfos.add(new TagInfo(tag.getId(),tag.getTagName())));
        return tagInfos;
    }
}
