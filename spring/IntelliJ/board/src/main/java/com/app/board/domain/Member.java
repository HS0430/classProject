package com.app.board.domain;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Member {
    private int userIdx;

    public int getUserIdx() {
        return userIdx;
    }
    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }

    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userAddress;
    private LocalDateTime regDate;
}
