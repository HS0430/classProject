package com.app.board.mapper;

import com.app.board.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    int insertMember(Member member);
    Member loginMember(@Param("userId") String userId, @Param("userPwd") String userPwd);
}
