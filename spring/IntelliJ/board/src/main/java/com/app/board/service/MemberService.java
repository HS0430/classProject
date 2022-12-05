package com.app.board.service;

import com.app.board.domain.Member;
import com.app.board.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public int insertMember(Member member){
        return memberMapper.insertMember(member);
    }

    public Member loginMember(String userId, String userPwd){
        return memberMapper.loginMember(userId, userPwd);
    }
}
