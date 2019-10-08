package me.perol.blog.controller;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import me.perol.blog.entity.User;
import me.perol.blog.filter.JWTAuthenticationFilter;
import me.perol.blog.form.UserForm;
import me.perol.blog.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Date;

/**
 * @Author: Perol
 * @Description:
 * @Date: Create in 10:00 2019/8/14
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController extends BaseController {

    @Resource
    UserMapper userMapper;
    @Resource
    PasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/logout")
    public void logoutToken(Principal principal) {

    }

    @GetMapping("/whoami")
    public String whoAmI(Principal principal) {
        return principal.getName();
    }

    @PostMapping("/login")
    public String getToken(HttpServletResponse httpServletResponse, @RequestBody UserForm userForm) {
        User user = userMapper.selectByName(userForm.getName());
        if (user != null) {
            if (bCryptPasswordEncoder.matches(userForm.getPassword(), user.getPassword())) {
                return successfulAuthentication(userForm.getName());
            }
        }
        return "";
    }

    private String successfulAuthentication(String username) {
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
                .signWith(JWTAuthenticationFilter.SIGNINKEY)
                .compact();
        return "Bearer " + token;
    }
}
