package me.perol.blog.controller;

import me.perol.blog.InO;
import me.perol.blog.config.ApplicationRunnerImpl;
import me.perol.blog.mapper.VisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import static me.perol.blog.InO.visitArray;


@RestController
@RequestMapping("/api/visit")
public class VisitController {
    //    @Autowired
//    private RedisTemplate redisTemplate;
    @Resource
    VisitMapper visitMapper;

    @PostMapping("/website")
    public void visitWebsite() {
        InO.plusWebsite();
    }

    @PostMapping("/pixez")
    public void visitPixez() {
        InO.plusPixez();
    }

    @GetMapping("/website")
    public Long numWebsite() {
        return visitArray[0];
    }

    @GetMapping("/pixez")
    public Long numPixez() {
        return visitArray[1];
    }
}
