package com.app.board.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class Board {
    private int rnum;
    private int bno;
    private String title;
    private String content;
    private String writer;
    private LocalDate regdate;
    private LocalDate updatedate;
}
