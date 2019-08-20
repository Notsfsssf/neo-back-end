package me.perol.blog.service.impl;

import me.perol.blog.entity.Comment;
import me.perol.blog.mapper.CommentMapper;
import me.perol.blog.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author perol
 * @since 2019-08-20
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
