package me.perol.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.perol.blog.entity.Article;
import me.perol.blog.entity.Comment;
import me.perol.blog.mapper.CommentMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author perol
 * @since 2019-08-20
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController extends BaseController {
    @Resource
    CommentMapper commentMapper;
    @GetMapping("/{id}")
    public List<Comment> getCommentByArticleId(@PathVariable("id") Long id)  {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        List<Comment> comments= commentMapper.selectList(queryWrapper);
        for (Comment comment:comments
             ) {
            comment.setEmail("");
        }
        return  comments;
    }
    @GetMapping("admin/{id}")
    public List<Comment> getAdminCommentByArticleId(@PathVariable("id") Long id)  {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        List<Comment> comments= commentMapper.selectList(queryWrapper);
        return  comments;
    }
    @PostMapping
    public void postComment(@RequestBody Comment comment){
        commentMapper.insert(comment);
    }

}
