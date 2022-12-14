package com.app.emp.service;

import com.app.emp.domain.EmpDTO;
import com.app.emp.domain.EmpSearchDTO;
import com.app.emp.mapper.EmpMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class EmpSelectService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public List<EmpDTO> selectList(EmpSearchDTO empSearchDTO){
        log.info("Emp List Service ...");
        return empMapper.selectList(empSearchDTO);
    }

    public List<EmpDTO> selectList2(){
        log.info("Emp List Service ...");
        return empMapper.selectList2();
    }
}
