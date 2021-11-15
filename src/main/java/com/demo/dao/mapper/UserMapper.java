package com.demo.dao.mapper;

import com.demo.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    public User getUserById(Long userId);
}
