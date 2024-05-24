package com.nuist;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class NuistWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenerateJWT(){

        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt=Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,
                "nuist") // 指定签名算法和密钥
                .setClaims(claims) // 自定义内容(payload 载荷）
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000)) //设置有效期
                .compact();
        System.out.println(jwt);
    }

    // 令牌过期和被篡改都不能成功解析
    @Test
    public void testParseJWT(){
        Claims claims = Jwts.parser()
                .setSigningKey("nuist") // 指定签名密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcxNjUzNjMwMn0.c3eVs1h3l59RXtw6KWXybfBYMxnKj6e4axSf1k32KH0")
                .getBody();
        System.out.println(claims);
    }

}
