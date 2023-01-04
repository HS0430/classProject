package com.app.todo.todo.domain;

import com.app.todo.todo.entity.Todo;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TodoDTO {

    private Integer t_tno;
    private Integer t_state;
    private String t_todo;
    private Integer t_priority;
    private LocalDate t_regdate;
    private LocalDate t_exdate;

    public Todo toTodoInsertEntiry(){
        return Todo.builder()
                .t_state(t_state)
                .t_todo(t_todo)
                .t_priority(t_priority)
                .t_exdate(t_exdate)
                .build();
    }

    public Todo toTodoUpdateEntity(){
        return Todo.builder()
                .t_state(t_state)
                .t_todo(t_todo)
                .t_priority(t_priority)
                .t_exdate(t_exdate)
                .build();
    }
}
