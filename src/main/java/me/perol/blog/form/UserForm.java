package me.perol.blog.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Perol
 * @Description:
 * @Date: Create in 15:39 2019/8/12
 */
@Data
public class UserForm {
    private String name;
    private String password;
}
