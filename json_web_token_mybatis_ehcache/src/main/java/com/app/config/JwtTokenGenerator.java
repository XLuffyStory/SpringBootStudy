package com.app.config;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenGenerator {

    /**
     * https://blog.csdn.net/gnail_oug/article/details/90240780?utm_medium=distribute.pc_relevant_bbs_down.none-task-blog-baidujs-1.nonecase&depth_1-utm_source=distribute.pc_relevant_bbs_down.none-task-blog-baidujs-1.nonecase
     * 如果在 当前类中 调用 @Cacheable 注解的方法，则缓存不会生效。
     * 解决办法：
     * 方法1：将缓存的方法单独放一个类里，与调用的方法分开，不放在同一个类里。
     * 方法2：从ApplicationContext里获取当前类的代理对象。
     * //注入当前对象的代理对象(在 @Cacheable 所在的类 ClassA注入当前对象的代理对象，如下所示)之后，可以在当前类中调用 @Cacheable 注解的方法
     * @Autowired
	private ClassA _this;
     */
    @Cacheable(value="jwtTokenCache")
    public  String getJwtToken(String username) {
	System.out.println(String.format("===================== username: %s =====================", username));
	System.out.println("===================== Generate JWT Token =====================");
	String jwtToken = Jwts.builder()
                .setSubject(username)
//                .claim("roles", person.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(JwtConfig.EXPIRATION_DATE)
                .signWith(JwtConfig.SIGNATURE_ALGORITHM, JwtConfig.SECRET_KEY)
                .compact();
	return jwtToken;
    }
}
