//package com.app.board.service.reply;
//
//import com.app.board.entity.Reply;
//import com.app.board.repository.ReplyRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//
//@Service
//public class ReplyEditService_20221220 {
//
//    @Autowired
//    private ReplyRepository replyRepository;
//
//    public Reply updateReply(Reply reply){
//        reply.setUpdatedate(LocalDate.now());
//        return replyRepository.save(reply);
//    }
//
//}