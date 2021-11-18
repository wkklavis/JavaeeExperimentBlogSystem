package com.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.dao.pojo.Blog_Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Blog_TagMapper extends BaseMapper<Blog_Tag> {
}
