package com.app.manager.mapper;

import com.app.manager.domain.DeptDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper2 {

    // 전체 부서 리스트
    @Select("SELECT * FROM DEPT")
    List<DeptDTO> selectAll();

    // 수정 / 상세 페이지
    @Select("SELECT * FROM dept WHERE deptno = #{deptno}")
    DeptDTO selectByDeptno(int deptno);

    // 수정(변경) 처리
    @Update("UPDATE dept SET dname=#{dname}, loc=#{loc} WHERE deptno=#{deptno}")
    int updateDept(DeptDTO deptDTO);

    // 삭제 처리
    @Delete("DELETE FROM dept WHERE deptno=#{deptno}")
    int deleteDept(int deptno);

    // 입력 처리
    @Insert("INSERT INTO dept VALUES (#{deptno}, #{dname}, #{loc})")
    int insertDept(DeptDTO deptDTO);
}
