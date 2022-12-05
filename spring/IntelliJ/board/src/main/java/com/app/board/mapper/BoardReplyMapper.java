package com.app.board.mapper;

import com.app.board.domain.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardReplyMapper {
    int regReply(Reply reply);

    List<Reply> selectReply(@Param("bno") int bno);

    int selectReplyCount(@Param("bno") int bno);

    int deleteReply(@Param("rno") int rno);
}
