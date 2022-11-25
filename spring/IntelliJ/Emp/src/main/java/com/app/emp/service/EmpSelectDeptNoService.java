package com.app.emp.service;

import com.app.emp.domain.DeptDTO;
import com.app.emp.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpSelectDeptNoService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public List<DeptDTO> selectDeptNo(){
        return empMapper.selectDeptNo();
    }
}
