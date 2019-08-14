package me.perol.blog.controller;

import io.jsonwebtoken.Jwts;
import me.perol.blog.entity.User;
import me.perol.blog.filter.JWTAuthenticationFilter;
import me.perol.blog.form.UserForm;
import me.perol.blog.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Author: Perol
 * @Description:
 * @Date: Create in 10:00 2019/8/14
 */
@RestController
@RequestMapping("/api/login")
public class LoginController extends BaseController {

    @Resource
    UserMapper userMapper;
@Resource
PasswordEncoder bCryptPasswordEncoder;
    @PostMapping
    public String getToken(HttpServletResponse httpServletResponse,@RequestBody UserForm userForm) {
        User user = userMapper.selectByName(userForm.getName());
        if (user != null) {
            if (bCryptPasswordEncoder.matches(userForm.getPassword(),user.getPassword())) {
               return successfulAuthentication(httpServletResponse, userForm.getName());

            }
        }
        return "";
    }


    private String  successfulAuthentication(HttpServletResponse httpServletResponse, String username) {

        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(JWTAuthenticationFilter.SIGNINKEY)
                .compact();
    return "Bearer " + token;
    }
}
