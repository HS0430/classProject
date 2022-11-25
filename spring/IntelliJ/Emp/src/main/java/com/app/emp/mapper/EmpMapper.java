package com.app.emp.mapper;

import com.app.emp.domain.DeptDTO;
import com.app.emp.domain.EmpDTO;
import com.app.emp.domain.EmpSearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    // 전체 사원 리스트
    List<EmpDTO> selectList(EmpSearchDTO empSearchDTO);
    List<EmpDTO> selectList2();

    // 수정 / 상세 페이지
    EmpDTO selectByEmpno(int empno);

    // 수정(변경) 처리
    int updateEmp(EmpDTO empDTO);

    // 삭제 처리
    int deleteEmp(int empno);

    // 입력 처리
    int insertEmp(EmpDTO empDTO);

    // 부서번호 리스트
    List<DeptDTO> selectDeptNo();
}
