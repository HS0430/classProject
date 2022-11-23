package com.firstcoding.todo_spring.controller;

import com.firstcoding.todo_spring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/todo/list")
@Log4j2
public class TodoListController {

    @Autowired
    private TodoService service;

    @GetMapping
    public ModelAndView getList(HttpServletRequest req, HttpServletResponse resp){
        log.info("Todo List Get ...");

//        req.setAttribute("title", "Todo List");
//        req.setAttribute("todoList", TodoListService.getInstance().selectTodoList();
        ModelAndView mav = new ModelAndView();

        mav.addObject("todoList", service.selectTodoList());
        mav.setViewName("todo/list");

        return mav;

    }
}
