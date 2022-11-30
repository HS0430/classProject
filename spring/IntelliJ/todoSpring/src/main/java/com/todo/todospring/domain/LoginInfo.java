package com.todo.todospring.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginInfo {

    @NotNull
    private String uid;
    @NotNull
    private String uname;
    private String uphoto;

}