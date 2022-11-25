package com.app.emp.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpDTO {

    @NotNull
    private int empno;

    @NotNull
    private String ename;

    @NotNull
    private String job;

    @NotNull
    private int mgr;

    @NotNull
    private LocalDate hiredate;

    @NotNull
    private double sal;

    @NotNull
    private double comm;

    @NotNull
    private int deptno;
}
