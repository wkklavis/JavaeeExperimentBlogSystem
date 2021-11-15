package com.demo.util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    //密钥
    private static final String jwtToken = "wkklavis$blog$system1221";

    /**
     * 根据用户id生成token
     * @return
     */
    public static String createToken(long userId){
        //载荷
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // 签发算法HS256，秘钥为jwtToken
                .setClaims(claims) // body数据
                .setIssuedAt(new Date(System.currentTimeMillis())) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));// 过期时间：一天
        String token = jwtBuilder.compact();
        return token;
    }
    public static Map<String,Object> validateToken(String token){
        //根据密钥验证token
        try{
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            //返回token载荷
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            throw e;
        }
    }
}
