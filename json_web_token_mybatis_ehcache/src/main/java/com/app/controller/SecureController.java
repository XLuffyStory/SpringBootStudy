package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;

/**
 * 测试JWT，如果验证成功直接返回数据，否则会被过滤器拦截
 */
@RestController
@RequestMapping("/secure")
public class SecureController {


    @PostMapping("/subject")
    public Object checkRoles(HttpServletRequest request) {
        // 从token中获取用户角色
        Claims claims = request.getAttribute("claims") != null ? (Claims) request.getAttribute("claims") : null;
        return "Subject: "+ claims.get("sub");
    }

}