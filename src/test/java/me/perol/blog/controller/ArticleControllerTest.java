package me.perol.blog.controller;

import me.perol.blog.entity.Article;
import me.perol.blog.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleControllerTest {
    @Resource
    ArticleMapper articleMapper;

    @Test
    public void getArticleById() {
      Article article=  articleMapper.selectById(5);
      System.out.println(article);
    }

    @Test
    public void getArticleByPage() {

    }

    @Test
    public void postArticle() {
        Article article = new Article();
        article.setUserId(1L);
        article.setTitle("dd");
        article.setContent("   w");
        article.setCreateTime(LocalDateTime.now());
        articleMapper.insert(article);
    }
}