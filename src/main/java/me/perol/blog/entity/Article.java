package me.perol.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author perol
 * @since 2019-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Article extends BaseEntity {

    @TableId(type= IdType.AUTO)
    private Long id;

    private Long userId;

    private String title;

    private String content;

    private String summary;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;


}
