package com.chat.server.test;

import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Td
 * @ClassName JWTTest
 * @description: TODO
 * @date 2023-04-21
 * @version: 1.0
 */
public class JWTTest {

    @Test
    public void createJWT() {

        HashMap<String, Object> data = new HashMap<>();
        data.put("id", 1);
        data.put("phone", "15871240437");

        long now = System.currentTimeMillis();
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "525150") //指定加密算法以及秘钥
                .setClaims(data) //存入数据
                .setExpiration(new Date(now + 150000)) //设置超时时间
                .compact();

        System.out.println(token);
    }

    @Test
    public void parseJWT() {

        try {
            String token = "eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE1ODcxMjQwNDM3IiwiaWQiOjEsImV4cCI6MTY4MjA3MzAxMn0.fV8dT1twTWLEKcy88WINHP7zAngxoft0A31LE2qpynM";

            Claims claims = Jwts.parser()
                    .setSigningKey("525150")
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println(claims.get("id"));

            System.out.println(claims.get("phone"));
        } catch (ExpiredJwtException e) {
            System.out.println("token已过期");
        } catch (SignatureException e) {
            System.out.println("token不合法");
        }

    }

}
