package me.perol.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import me.perol.blog.entity.Article;
import me.perol.blog.entity.User;
import me.perol.blog.mapper.ArticleMapper;
import me.perol.blog.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author perol
 * @since 2019-08-07
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController extends BaseController {
    @Resource
    ArticleMapper articleMapper;
    @Resource
    UserMapper userMapper;

    @GetMapping
    public List<Article> getArticle(@RequestParam(value = "current", required = false) Long current, @RequestParam(value = "size", required = false) Long size) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<Article>();
        queryWrapper.orderByDesc("id");
        if (current == null || size == null) {
            return articleMapper.selectList(queryWrapper);
        } else {
            Page<Article> page = new Page<>(current, size);
            return articleMapper.selectPage(page, queryWrapper).getRecords();
        }
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable("id") Long id)  {
        return articleMapper.selectById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postArticle(Principal principal, @RequestBody Article article) {
        User user = userMapper.selectByName(principal.getName());
        article.setCreateTime(LocalDateTime.now());
        article.setUserId(user.getId());
        articleMapper.insert(article);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(Principal principal, @PathVariable("id") Long id) {
        boolean ok = articleMapper.selectById(id).getUserId().equals(userMapper.selectByName(principal.getName()).getId());
        if (ok) {
            articleMapper.deleteById(id);
        } else {
            throw new RuntimeException("");
        }
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateArticle(Principal principal, @PathVariable("id") Long id, @RequestBody Article article) {
        boolean ok = article.getUserId().equals(userMapper.selectByName(principal.getName()).getId());
        if (ok) {
            article.setId(id);
            article.setCreateTime(null);
            article.setUpdateTime(LocalDateTime.now());
            articleMapper.updateById(article);
        } else {
            throw new RuntimeException("");
        }
    }
}
