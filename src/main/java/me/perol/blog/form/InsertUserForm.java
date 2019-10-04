package me.perol.blog.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InsertUserForm {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
}
