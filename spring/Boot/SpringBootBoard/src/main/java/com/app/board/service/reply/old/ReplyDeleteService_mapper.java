package com.app.board.service.reply.old;

import com.app.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyDeleteService_mapper {

    @Autowired
    private ReplyMapper replyMapper;

    public int deleteByRno(int rno){
        return replyMapper.deleteByRno(rno);
    }
}