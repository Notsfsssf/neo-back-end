package me.perol.blog.controller;


import me.perol.blog.entity.User;
import me.perol.blog.form.InsertUserForm;
import me.perol.blog.form.UserForm;
import me.perol.blog.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.Principal;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author perol
 * @since 2019-08-07
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
    @Resource
    UserMapper userMapper;
    @Resource
    PasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        User user = userMapper.selectById(id);
        user.setPassword("");
        return user;
    }

    @PostMapping()
    public void InsertUser(@RequestBody @Valid InsertUserForm user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User user1 = new User();
        BeanUtils.copyProperties(user1, user);
        userMapper.insert(user1);
    }

    private void confirm(Principal principal, Long id) {
        User user = userMapper.selectByName(principal.getName());
        if (!id.equals(user.getId())) {
            throw new RuntimeException("");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(Principal principal, @PathVariable("id") Long id) {
        confirm(principal, id);
        userMapper.deleteById(id);
    }
}
