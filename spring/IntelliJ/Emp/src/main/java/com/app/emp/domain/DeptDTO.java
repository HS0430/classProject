package com.app.emp.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DeptDTO {

    private int deptno;
    private String dname;
    private String loc;

}
