package com.app.todo.todo.controller;

import com.app.todo.todo.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoListController {

    @Autowired
    private TodoListService todoListService;

    @GetMapping("/list")
    public void todoList(
            @RequestParam(value = "p", defaultValue = "1") int pageNum,
            Model model
    ){
        model.addAttribute("listPage", todoListService.getTodoPage(pageNum));
    }
}
