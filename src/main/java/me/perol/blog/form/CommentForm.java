package me.perol.blog.form;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Perol
 * @Description:
 * @Date: Create in 22:20 2019/8/21
 */
@Data
public class CommentForm {
    private String content;

    private String name;

    private String email;
}
