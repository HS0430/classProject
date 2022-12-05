package com.app.board.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NotNull
@Getter
@Setter
@Builder
@ToString
public class Member {
    private int userIdx;
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userAddress;
    private LocalDateTime regDate;
}
