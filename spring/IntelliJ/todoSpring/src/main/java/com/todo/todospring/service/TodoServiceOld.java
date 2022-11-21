package com.todo.todospring.service;

import com.todo.todospring.dao.TodoDaoOld;
import com.todo.todospring.domain.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TodoServiceOld {

//    @Autowired
    private final TodoDaoOld dao;

    public TodoServiceOld(TodoDaoOld dao) {
        this.dao = dao;
    }

    public void test(){
        log.info("TodoService test...");
    }

    public List<TodoDTO> getTodoList() {
        log.info("Todo Service getTodoList() ...");
        List<TodoDTO> list = null;

        dao.selectAll();

        return list;
    }

}
