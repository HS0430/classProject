package com.app.board.service;

import com.app.board.domain.Reply;
import com.app.board.mapper.BoardReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardReplyService {

    @Autowired
    private BoardReplyMapper boardReplyMapper;

    public int regReply(Reply reply){
        return boardReplyMapper.regReply(reply);
    }

    public List<Reply> selectReply(int bno){
        return boardReplyMapper.selectReply(bno);
    }

    public int selectReplyCount(int bno){
        return boardReplyMapper.selectReplyCount(bno);
    }

    public int deleteReply(int rno){
        return boardReplyMapper.deleteReply(rno);
    }

}
