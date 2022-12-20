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
//public class ReplyInsertService_20221220 {
//
//    @Autowired
//    private ReplyRepository replyRepository;
//
//    public Reply insertReply(Reply reply){
//        reply.setReplydate(LocalDate.now());
//        reply.setUpdatedate(LocalDate.now());
//        return replyRepository.save(reply);
//    }
//}
