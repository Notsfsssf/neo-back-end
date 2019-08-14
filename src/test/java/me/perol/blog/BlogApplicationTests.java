package me.perol.blog;

import me.perol.blog.entity.User;
import me.perol.blog.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setEmail("pxezfeedback@outlook.com");
        user.setName("Perol");
        user.setPassword("1122");
        userMapper.insert(user);

    }

    @Test
    public void searchUser() {
        Map<String, Object> map = new HashMap<>();
        User users = userMapper.selectById(1);
        System.out.println(users);
    }
}
