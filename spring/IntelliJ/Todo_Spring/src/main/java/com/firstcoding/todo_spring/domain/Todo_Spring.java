package com.firstcoding.todo_spring.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Todo_Spring {
    private long tno;
    private String todo;
    private LocalDate dueDate;
    private boolean finished;
}
