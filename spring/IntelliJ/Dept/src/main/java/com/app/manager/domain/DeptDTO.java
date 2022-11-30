package com.app.manager.domain;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptDTO {

    @Min(value = 1)
    @Max(value = 99)
    @Positive       // 양수 @Negative -> 음수
    private int deptno;

    @NotEmpty       // 문자열은 비어있지 않은 상태, List -> 요소의 개수가 비어있는 지
    private String dname;

    @NotEmpty
    private String loc;

}

// @Future : 현재 시간보다 미래이어야 한다.
// @Email : 이메일 체크 (@ 존재만 체크)
// @NotBlank : 공백 문자열도 체크 '  '
// @NotNull : Null 값이 아니다