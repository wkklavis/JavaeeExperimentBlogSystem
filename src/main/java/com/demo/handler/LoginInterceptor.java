package com.demo.handler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.demo.dao.pojo.User;
import com.demo.service.LoginService;
import com.demo.util.JWTUtils;
import com.demo.util.UserThreadLocal;
import com.demo.vo.Error;
import com.demo.vo.ReturnResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;

/**
 * 登录拦截
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    LoginService loginService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            //非controller处理方法
            System.out.println("OPTIONS请求，放行");
            return true;
        }
        //头部取出token
        String token = request.getHeader("Authorization");
        User user = loginService.pasreToken(token);

        //参考den日志打印
        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");

        if (user!=null) {
            UserThreadLocal.put(user);
            return true;
        }
        ReturnResult returnResult = ReturnResult.returnFail(Error.NOT_LOGGING.getErrorCode(),Error.NOT_LOGGING.getErrorMsg());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(401);
        response.getWriter().append(JSON.toJSONString(returnResult));
        return false;
    }

    //DispatcherServlet进行视图的渲染之后
    //多用于清理资源
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
