package com.app.emp.service;

import com.app.emp.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpDeleteService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public int deleteEmp(int empno){
        return empMapper.deleteEmp(empno);
    }
}
