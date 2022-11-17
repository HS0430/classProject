package com.firstcoding.todo_spring.controller;

import com.firstcoding.todo_spring.domain.Todo_Spring;
import com.firstcoding.todo_spring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Controller
@RequestMapping("/insert")
@Log4j2
public class TodoInsertController {

    @PostMapping
    public ModelAndView insertTodo(HttpServletRequest req, HttpServletResponse resp){
        log.info("Todo insert...");
        ModelAndView mav = new ModelAndView();

        String todoObj = req.getParameter("todo");
        String dueDate = req.getParameter("dueDate");

        Todo_Spring todo = Todo_Spring.builder()
                .todo(todoObj)
                .dueDate(LocalDate.parse(dueDate))
                .build();

        int result = TodoService.getInstance().insertTodo(todo);
//        mav.addObject("todoList", TodoService.getInstance().selectTodoList());
        mav.setViewName("list");

        return mav;

    }
}
