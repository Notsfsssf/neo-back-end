package me.perol.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.perol.blog.entity.Article;
import me.perol.blog.mapper.ArticleMapper;
import me.perol.blog.service.IArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author perol
 * @since 2019-08-08
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
