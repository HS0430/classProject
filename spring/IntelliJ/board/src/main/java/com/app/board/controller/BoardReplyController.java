package com.app.board.controller;

import com.app.board.domain.Reply;
import com.app.board.service.BoardReplyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/board/*")
public class BoardReplyController {

    @Autowired
    private BoardReplyService boardReplyService;

    @GetMapping("/replyList")
    @ResponseBody
    public Map<String, Object> boardReplyList(Model model, HttpServletRequest req){
        Map<String, Object> map = new HashMap<String, Object>();

        log.info("board Reply List...");

        int bno = Integer.parseInt(req.getParameter("bno"));
        log.info(bno);

        int replyCount = boardReplyService.selectReplyCount(bno);

        List<Reply> replyList = new ArrayList<>();
        replyList = boardReplyService.selectReply(bno);
        map.put("replyList", replyList);
        map.put("replyCount", replyCount);

        return map;
    }

    @PostMapping("/replyReg")
    public int regReply(Reply reply){
        log.info(reply);
        int result = boardReplyService.regReply(reply);

        return result;
    }

    @GetMapping("/replyDelete")
    public int deleteReply(@RequestParam("rno") int rno){
        int result = boardReplyService.deleteReply(rno);

        return result;
    }

}
