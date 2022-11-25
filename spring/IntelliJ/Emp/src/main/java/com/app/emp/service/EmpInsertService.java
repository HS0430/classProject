package com.app.emp.service;

import com.app.emp.domain.EmpDTO;
import com.app.emp.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpInsertService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    @Transactional
    public int insertEmp(EmpDTO empDTO){
        return empMapper.insertEmp(empDTO);
    }
}
