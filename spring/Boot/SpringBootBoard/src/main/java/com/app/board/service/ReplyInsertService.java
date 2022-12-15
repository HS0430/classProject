package com.app.board.service;

import com.app.board.Entity.Reply;
import com.app.board.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReplyInsertService {

    @Autowired
    private ReplyRepository replyRepository;

    public Reply insertReply(Reply reply){
        reply.setReplydate(LocalDate.now());
        reply.setUpdatedate(LocalDate.now());
        return replyRepository.save(reply);
    }
}
