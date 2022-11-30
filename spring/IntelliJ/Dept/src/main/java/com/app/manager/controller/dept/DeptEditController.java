package com.app.manager.controller.dept;

import com.app.manager.domain.DeptDTO;
import com.app.manager.service.dept.DeptEditService;
import com.app.manager.service.dept.DeptReadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/dept/edit")
public class DeptEditController {

    @Autowired
    private DeptReadService deptReadService;
    @Autowired
    private DeptEditService deptEditService;

    @GetMapping
    public void getEditForm(@RequestParam("deptno") int deptno, Model model){
        log.info("Edit Get ...");
        model.addAttribute("dept", deptReadService.getDept(deptno));
    }

    @PostMapping
    public String edit(DeptDTO deptDTO){
        log.info("Edit Post ... ");
        log.info(deptDTO);
        deptEditService.editDept(deptDTO);
        return "redirect:/dept/list";
    }
}
