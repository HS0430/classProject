package com.app.emp.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpSearchDTO {

    private String searchType;
    private String keyword;
//    private int empno;
//    private String ename;
//    private String job;
//    private int deptno;

}
