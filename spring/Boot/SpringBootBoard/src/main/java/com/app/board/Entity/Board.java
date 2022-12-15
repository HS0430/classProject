package com.app.board.Entity;

import com.app.board.domain.BoardDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="tbl_board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer bno;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String writer;

    @Column
    private String photo;

    @Column(insertable = false, updatable = false)
    private LocalDate regdate;

    private LocalDate updatedate;

    @Column
    private Integer replycnt;

}
