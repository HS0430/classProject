package com.app.emp.controller;

import com.app.emp.service.EmpSelectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class EmpSelectController {

    @Autowired
    private EmpSelectService empSelectService;

    @RequestMapping("/emp/list")
    public void selectList(Model model){
        log.info("Emp List Controller ...");
        model.addAttribute("emplist", empSelectService.selectList());
    }
}
