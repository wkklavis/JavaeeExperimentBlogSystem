package com.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.dao.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
//mybatis-plus建立BaseMapper<Blog>关联
public interface BlogMapper extends BaseMapper<Blog> {
    List<Blog> getBlogsByTag(Long tagId);

    List<Blog> getBlogsByQueryKey(String key);
}
