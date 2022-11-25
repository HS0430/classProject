package com.app.emp.service;

import com.app.emp.domain.EmpDTO;
import com.app.emp.mapper.EmpMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmpSelectByempnoService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public EmpDTO selectByEmpno(int empno){
        return empMapper.selectByEmpno(empno);
    }
}
