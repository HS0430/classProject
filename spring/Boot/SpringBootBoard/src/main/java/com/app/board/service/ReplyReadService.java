package com.app.board.service;

import com.app.board.Entity.Reply;
import com.app.board.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyReadService {

    @Autowired
    private ReplyRepository replyRepository;

    public Reply selectByRno(int rno){
        return replyRepository.selectByRno(rno);
    }
}
