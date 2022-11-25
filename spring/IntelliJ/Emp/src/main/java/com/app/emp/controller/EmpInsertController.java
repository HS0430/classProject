package com.app.emp.controller;

import com.app.emp.domain.EmpDTO;
import com.app.emp.service.EmpInsertService;
import com.app.emp.service.EmpSelectDeptNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
    public String insertEmp(EmpDTO empDTO){
        empInsertService.insertEmp(empDTO);
        return "redirect:/emp/list";
    }
}
