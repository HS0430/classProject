package com.app.board.service;

import com.app.board.Entity.Reply;
import com.app.board.Repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyListService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> selectAll(int bno){
        return replyRepository.selectAll(bno);
    }
}
