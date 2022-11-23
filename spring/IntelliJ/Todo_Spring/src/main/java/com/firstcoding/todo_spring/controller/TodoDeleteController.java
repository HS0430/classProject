package com.firstcoding.todo_spring.controller;

import com.firstcoding.todo_spring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo/remove")
@Log4j2
public class TodoDeleteController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public String deleteTodo(@RequestParam("tno") long tno){
       log.info("todo delete ...");
       todoService.deleteTodo(tno);

        return "redirect:/todo/list";
    }
}
