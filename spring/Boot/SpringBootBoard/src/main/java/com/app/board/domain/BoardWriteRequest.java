package com.app.board.domain;

import com.app.board.Entity.Board;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardWriteRequest {

    private String title;
    private String writer;
    private String content;
    private MultipartFile formFile;


    public Board toBoard(){
        return Board.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

}