package com.app.todo.todo.controller;

import com.app.todo.todo.domain.TodoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo/write")
public class TodoWriteController {

    @GetMapping
    public void getWrite(){

    }

    @PostMapping
    public String postWrite(
            TodoDTO todoDTO
    ){

        return "redirect:/todo/list";
    }
}
