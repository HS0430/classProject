package com.app.emp.controller;

import com.app.emp.service.EmpDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmpDeleteController {

    @Autowired
    private EmpDeleteService empDeleteService;

    @RequestMapping("/emp/delete")
    public String deleteEmp(@RequestParam("empno") int empno){
        empDeleteService.deleteEmp(empno);
        return "redirect:/emp/list";
    }
}
