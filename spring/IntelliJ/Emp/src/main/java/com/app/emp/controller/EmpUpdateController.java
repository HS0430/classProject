package com.app.emp.controller;

import com.app.emp.domain.EmpDTO;
import com.app.emp.service.EmpSelectByempnoService;
import com.app.emp.service.EmpSelectDeptNoService;
import com.app.emp.service.EmpSelectService;
import com.app.emp.service.EmpUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/emp/update")
public class EmpUpdateController {

    @Autowired
    private EmpSelectByempnoService empSelectByempnoService;
    @Autowired
    private EmpUpdateService empUpdateService;

    @Autowired
    private EmpSelectDeptNoService empSelectDeptNoService;

    @Autowired
    private EmpSelectService empSelectService;

    @GetMapping
    public void updateEmpForm(@RequestParam("empno") int empno, Model model){
        model.addAttribute("emp", empSelectByempnoService.selectByEmpno(empno));
        model.addAttribute("dept", empSelectDeptNoService.selectDeptNo());
        model.addAttribute("emplist", empSelectService.selectList2());
    }

    @PostMapping
    public String updateEmp(EmpDTO empDTO){
        empUpdateService.updateEmp(empDTO);
        return "redirect:/emp/list";
    }
}
