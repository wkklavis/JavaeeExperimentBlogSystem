package com.demo.dao.mapper;

import com.demo.dao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface TagMapper {
    public List<Tag> getTagsByBlogId(Long blodId);
}
