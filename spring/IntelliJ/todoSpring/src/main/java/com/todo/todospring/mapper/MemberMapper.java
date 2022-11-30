package com.todo.todospring.mapper;

import com.todo.todospring.domain.Member;
import com.todo.todospring.domain.MemberRegRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    int insertMember(Member member);
    Member selectByIdPw(@Param("uid") String uid, @Param("pw") String pw);
}
