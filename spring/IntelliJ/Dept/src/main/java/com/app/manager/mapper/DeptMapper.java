package com.app.manager.mapper;

import com.app.manager.domain.DeptDTO;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 전체 부서 리스트
    List<DeptDTO> selectAll();

    // 수정 / 상세 페이지
    DeptDTO selectByDeptno(int deptno);

    // 수정(변경) 처리
    int updateDept(DeptDTO deptDTO);

    // 삭제 처리
    int deleteDept(int deptno);

    // 입력 처리
    int insertDept(DeptDTO deptDTO);
}
