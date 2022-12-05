package com.app.board.controller;

import com.app.board.domain.Member;
import com.app.board.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String memberLoginView(){
        return "/loginView";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String memberLogin(@RequestParam("userId") String userId, @RequestParam("userPwd") String userPwd, HttpServletRequest req){

        log.info("userId : " + userId + "\nuserPwd : " + userPwd);
        Member loginChk = memberService.loginMember(userId, userPwd);

        log.info(loginChk);
        if(loginChk != null){
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", loginChk.getUserId());
            session.setAttribute("loginName", loginChk.getUserName());
        }
//        else{
//        }
        return "redirect:/board/list";
    }

    @RequestMapping(method = RequestMethod.GET, value="/member/insert")
    public String insertMemberView(){
        return "/member/insert";
    }

    @RequestMapping(method = RequestMethod.POST, value="/member/insert")
    public String insertMember(Member member){
        log.info(member);
        memberService.insertMember(member);
        return "redirect:/login";
    }
}
