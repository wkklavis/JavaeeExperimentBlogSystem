package com.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.dao.mapper.UserMapper;
import com.demo.dao.pojo.User;
import com.demo.service.LoginService;
import com.demo.service.UserService;
import com.demo.vo.Error;
import com.demo.vo.ReturnResult;
import com.demo.vo.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    LoginService loginService;
    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.select("id","username","password","nickname","avatar","email","status","create_date","admin");
        queryWrapper.last("limit 1");
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public ReturnResult getUserByToken(String token) {
        User user = loginService.pasreToken(token);
        if (user==null)return ReturnResult.returnFail(Error.PARAMETER_VALIDATION_ERROR.getErrorCode(),Error.PARAMETER_VALIDATION_ERROR.getErrorMsg());
        UserInfo userInfo = new UserInfo(user.getId(),user.getNickname(),user.getAvatar());
        return ReturnResult.returnSuccess(userInfo);
    }
}
