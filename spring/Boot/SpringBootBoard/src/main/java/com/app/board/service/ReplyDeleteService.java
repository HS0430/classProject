package com.app.board.service;

import com.app.board.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyDeleteService {

    @Autowired
    private ReplyRepository replyRepository;

    public int deleteByRno(int rno){
        return replyRepository.deleteByRno(rno);
    }
}