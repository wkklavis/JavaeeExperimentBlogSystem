package com.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.dao.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
