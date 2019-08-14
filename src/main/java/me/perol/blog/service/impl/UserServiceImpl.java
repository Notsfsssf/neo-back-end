package me.perol.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.perol.blog.entity.User;
import me.perol.blog.mapper.UserMapper;
import me.perol.blog.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
