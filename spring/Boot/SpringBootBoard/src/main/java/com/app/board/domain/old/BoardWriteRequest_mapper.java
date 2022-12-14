package com.app.board.domain.old;

import com.app.board.domain.BoardDTO;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardWriteRequest_mapper {

    private String title;
    private String writer;
    private String content;
    private MultipartFile formFile;


    public BoardDTO toBoardDTO(){
        return BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

}