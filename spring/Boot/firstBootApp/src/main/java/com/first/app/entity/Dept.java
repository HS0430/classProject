package com.first.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="dept")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // mysql mariaDB auto Increment
    @Column
    private Integer deptno;

    @Column(length = 20, nullable = false)
    private String dname;

    @Column(length = 20, nullable = false)
    private String loc;
}
