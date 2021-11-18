package com.demo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.dao.pojo.BlogText;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BlogTextMapper extends BaseMapper<BlogText> {
}
