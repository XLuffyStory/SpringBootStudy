package com.app.controller;


import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.config.JwtTokenGenerator;
import com.app.model.ReqUser;
import com.app.model.User;
import com.app.service.UserService;


@RestController
@CacheConfig
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;
    

    /**
     * 用户注册
     */
    @PostMapping(value = "/register")
    public String register(@RequestBody ReqUser reqPerson) throws ServletException {

        // 检查输入
        if (reqPerson.getUsername() == "" || reqPerson.getUsername() == null || reqPerson.getPassword() == "" || reqPerson.getPassword() == null) {
            throw new ServletException("Username or Password invalid!");
        }

        // 检查用户是否已被注册
        if (userService.findUserByUsername(reqPerson.getUsername()) != null) {
            throw new ServletException("Username is used!");
        }


        userService.save(new User(reqPerson.getUsername(), reqPerson.getPassword()));

        return "Register Success!";
    }

    /**
     * 检查用户的登录信息，然后创建并返回给前端 jwt token 令牌
     *
     * @param reqUser
     * @return jwt token
     * @throws ServletException
     */
    @PostMapping("/login")
    public String login(@RequestBody ReqUser reqUser) throws ServletException {

        // 检查输入
        if (reqUser.getUsername() == "" || reqUser.getUsername() == null || reqUser.getPassword() == "" || reqUser.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        User person = userService.findUserByUsername(reqUser.getUsername());

        // 检查用户是否存在。密码是否正确
        if (userService.findUserByUsername(reqUser.getUsername()) == null || !reqUser.getPassword().equals(person.getPassword())) {
            throw new ServletException("Username or password not valid");
        }

        // 创建 Jwt token 令牌，将username写入令牌
        String jwtToken = jwtTokenGenerator.getJwtToken(reqUser.getUsername());

        return jwtToken;
    }
    
    
}
