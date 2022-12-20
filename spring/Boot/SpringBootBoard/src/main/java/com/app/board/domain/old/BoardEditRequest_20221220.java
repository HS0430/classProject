//package com.app.board.domain;
//
//import com.app.board.entity.Board;
//import lombok.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Builder
//public class BoardEditRequest_20221220 {
//
//    private int bno;
//    private int curPageNum;
//    private String title;
//    private String writer;
//    private String content;
//    private String oldFile;
//    private MultipartFile formFile;
//
//    public Board toBoard(){
//        return Board.builder()
//                .bno(bno)
//                .writer(writer)
//                .title(title)
//                .content(content)
//                .photo(oldFile)
//                .build();
//    }
//}
