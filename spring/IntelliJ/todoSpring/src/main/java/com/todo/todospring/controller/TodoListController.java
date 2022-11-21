package com.todo.todospring.controller;

import com.todo.todospring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class TodoListController {

//    @Autowired
    private final TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todo/list")
    public String getTodoList(Model model){
        log.info("TodoListController getTodoList() ...");
        model.addAttribute("todoList", todoService.getTodoList());

        return "todo/list";
    }
}