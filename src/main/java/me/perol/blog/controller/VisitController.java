package me.perol.blog.controller;

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
import java.io.Serializable;

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
        visitArray[0] += 1;
    }

    @PostMapping("/pixez")
    public void visitPixez() {
        visitArray[1] += 1;
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
