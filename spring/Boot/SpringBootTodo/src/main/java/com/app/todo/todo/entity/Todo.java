package com.app.todo.todo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer t_tno;

    @Column
    private Integer t_state;

    @Column
    private String t_todo;

    @Column
    private Integer t_priority;

    @Column(updatable = false)
    private LocalDate t_regdate;

    @Column(insertable = false, updatable = false)
    private LocalDate t_exdate;

}
