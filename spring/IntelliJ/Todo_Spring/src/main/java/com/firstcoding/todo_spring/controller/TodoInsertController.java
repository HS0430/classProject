package com.firstcoding.todo_spring.controller;

import com.firstcoding.todo_spring.domain.Todo_Spring;
import com.firstcoding.todo_spring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Controller
@RequestMapping("/todo/insert")
@Log4j2
public class TodoInsertController {

    @Autowired
    private TodoService service;

    @GetMapping
    public String insertForm(){

        return "todo/insert";
    }

    @PostMapping
    public String insertTodo(@RequestParam("todo") String todo, @RequestParam("dueDate") String dueDate){
        log.info("Todo insert...");

        Todo_Spring todoDto = Todo_Spring.builder()
                .todo(todo)
                .dueDate(LocalDate.parse(dueDate))
                .build();

        int result = service.insertTodo(todoDto);

        return "redirect:/todo/list";

    }
}
