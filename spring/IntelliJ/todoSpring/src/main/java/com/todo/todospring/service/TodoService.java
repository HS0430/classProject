package com.todo.todospring.service;

import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.mapper.TodoMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    public List<TodoDTO> getTodoList() {
        return todoMapper.selectAll();
    }

    public TodoDTO getTodo(long tno) {
        return todoMapper.selectByTno(tno);
    }

    @Transactional
    public int insertTodo(TodoDTO todoDTO) {
        return todoMapper.insertToDo(todoDTO);
    }

    @Transactional
    public int modify(TodoDTO todoDTO) {
        return todoMapper.updateTodo(todoDTO);
    }

    @Transactional
    public int deleteBytno(long tno) {
        return todoMapper.deleteTodo(tno);
    }
}