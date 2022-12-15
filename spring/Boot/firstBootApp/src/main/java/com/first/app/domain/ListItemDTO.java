package com.first.app.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ListItemDTO {

    private Integer empno;
    private String ename;
    private String  job;
    private String dname;
    private String loc;

}
