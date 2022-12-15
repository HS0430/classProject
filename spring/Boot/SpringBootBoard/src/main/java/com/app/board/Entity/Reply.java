package com.app.board.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tbl_reply")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int rno;

    @Column
    private int bno;

    @Column
    private String reply;

    @Column
    private String replyer;

    @Column
    private LocalDate replydate;

    @Column
    private LocalDate updatedate;

}
