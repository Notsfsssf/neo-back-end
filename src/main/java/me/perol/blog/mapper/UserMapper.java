package me.perol.blog.mapper;

import me.perol.blog.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author perol
 * @since 2019-08-07
 */

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user")
    public List<User> findAll();

    @Select("SELECT * FROM user WHERE name=#{name} LIMIT 1")
    User selectByName(String username);
}
