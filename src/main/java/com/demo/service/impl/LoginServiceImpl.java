package com.demo.service.impl;

import com.demo.dao.pojo.User;
import com.demo.service.LoginService;
import com.demo.service.UserService;
import com.demo.util.JWTUtils;
import com.demo.vo.Error;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.LoginParam;
import io.jsonwebtoken.Jwt;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    //加密盐
    private static final String slat = "user$encryption";

    @Autowired
    UserService userService;

    @Override
    public ReturnResult login(LoginParam loginParam) {
        //参数校验
        if (loginParam.getUsername()==null||loginParam.getPassword()==null){
            return ReturnResult.returnFail(Error.PARAMETER_VALIDATION_ERROR.getErrorCode(),Error.PARAMETER_VALIDATION_ERROR.getErrorMsg());
        }
        //用加密盐加密
        loginParam.setPassword(DigestUtils.md5Hex(loginParam.getPassword() + slat));
        User user = userService.getUserByUsernameAndPassword(loginParam.getUsername(),loginParam.getPassword());

        if (user==null){
            return ReturnResult.returnFail(Error.USER_NOT_EXIST.getErrorCode(),Error.USER_NOT_EXIST.getErrorMsg());
        }
        String token = JWTUtils.createToken(user.getId());

        return ReturnResult.returnSuccess(token);
    }

    /**
     * 从token中解析id，再从数据库取出user
     * @param token
     * @return
     */
    @Override
    public User pasreToken(String token) {
        if (token==null)return null;
        Map<String, Object> stringObjectMap = JWTUtils.validateToken(token);
        if (stringObjectMap==null)return null;
        Long userId = (Long.valueOf(stringObjectMap.get("userId").toString()));
        return userService.getUserById(userId);
    }

    @Override
    public ReturnResult logout(String token) {
        return null;
    }


}
