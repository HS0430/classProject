package com.app.manager.controller.emp;


import com.app.manager.domain.EmpDTO;
import com.app.manager.service.dept.DeptListService;
import com.app.manager.service.emp.EmpEditService;
import com.app.manager.service.emp.EmpListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/emp/edit")
public class EmpEditController {

    @Autowired
    private EmpListService empListService;

    @Autowired
    private DeptListService deptListService;

    @Autowired
    private EmpEditService empEditService;

    @GetMapping
    public void getEditForm(Model model) {

        model.addAttribute("empList", empListService.getEmpList());
        model.addAttribute("deptList", deptListService.getList());

        log.info("regForm ...");
    }

    @PostMapping
    public String reg(
            EmpDTO empDTO
    ) {

        log.info("reg Post ...");
        log.info(empDTO);

        //regService.insertEmp(empDTO);

        return "redirect:/emp/list";
    }

}