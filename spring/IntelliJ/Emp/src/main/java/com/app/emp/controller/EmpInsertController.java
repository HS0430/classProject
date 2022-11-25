package com.app.emp.controller;

import com.app.emp.domain.EmpDTO;
import com.app.emp.service.EmpInsertService;
import com.app.emp.service.EmpSelectDeptNoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/emp/insert")
public class EmpInsertController {

    @Autowired
    private EmpInsertService empInsertService;

    @Autowired
    private EmpSelectDeptNoService empSelectDeptNoService;

    @GetMapping
    public void insertEmpForm(Model model){
        model.addAttribute("dept", empSelectDeptNoService.selectDeptNo());
    }

    @PostMapping
    public String insertEmp(@Valid EmpDTO empDTO, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            for(ObjectError objectError: bindingResult.getAllErrors()){
                log.info(objectError.getCodes()[1] + " : " + objectError.getDefaultMessage());
            }
        }
        empInsertService.insertEmp(empDTO);
        return "redirect:/emp/list";
    }
}
