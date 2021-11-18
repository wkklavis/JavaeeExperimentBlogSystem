package com.demo.util;

import com.demo.dao.pojo.User;
//参考的用户线程类
//存储当前访问用户信息
public class UserThreadLocal {

    private UserThreadLocal(){}
    //线程变量隔离
    //多线程访问保证唯一user
    private static final ThreadLocal<User> LOCAL = new ThreadLocal<>();

    public static void put(User user){
        LOCAL.set(user);
    }

    public static User get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
