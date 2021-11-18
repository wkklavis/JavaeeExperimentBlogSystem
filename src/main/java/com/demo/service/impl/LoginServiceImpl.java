package com.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.demo.dao.pojo.User;
import com.demo.service.LoginService;
import com.demo.service.UserService;
import com.demo.util.JWTUtils;
import com.demo.vo.Error;
import com.demo.vo.ReturnResult;
import com.demo.vo.param.LoginParam;
import com.demo.vo.param.RegisterParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
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
        User user = userService.getUserByUsername(loginParam.getUsername());
        //用户不存在
        if (user==null){
            return ReturnResult.returnFail(Error.USER_NOT_EXIST.getErrorCode(),Error.USER_NOT_EXIST.getErrorMsg());
        }
        //密码错误
        if (!user.getPassword().equals(loginParam.getPassword())){
            return ReturnResult.returnFail(Error.WRONG_PASSWORD.getErrorCode(),Error.WRONG_PASSWORD.getErrorMsg());
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

    @Override
    public ReturnResult register(RegisterParam registerParam) {
        String username = registerParam.getUsername();
        String nickname = registerParam.getNickname();
        String password = registerParam.getPassword();
        String email = registerParam.getEmail();
        if (StringUtils.isBlank(username)||StringUtils.isBlank(nickname)
            ||StringUtils.isBlank(password)||StringUtils.isBlank(email))   {
            return ReturnResult.returnFail(Error.PARAMETER_VALIDATION_ERROR.getErrorCode(),Error.USER_NOT_EXIST.getErrorMsg());
        }
        User user = userService.getUserByUsername(username);
        if (user!=null){
            return ReturnResult.returnFail(Error.USER_EXISTED.getErrorCode(),Error.USER_EXISTED.getErrorMsg());
        }
        user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(DigestUtils.md5Hex(password+slat));
        user.setEmail(email);
        user.setCreateDate(System.currentTimeMillis());
        user.setAvatar("/static/img/logo.b3a48c0.png");
        user.setStatus("");
        user.setAdmin(0);
        userService.save(user);
        String token = JWTUtils.createToken(user.getId());
        return ReturnResult.returnSuccess(token);

    }

}
