package com.app.todo.todo.service;

import com.app.todo.todo.domain.TodoListPage;
import com.app.todo.todo.entity.Todo;
import com.app.todo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoListPage getTodoPage(int pageNum){
        Page<Todo> page = todoRepository.findAll(PageRequest.of(pageNum-1, 10));

        List<Todo> list = page.getContent();

        int totalCount = (int) page.getTotalElements();

        TodoListPage todoListPage = new TodoListPage(10, pageNum, list, totalCount);

        return todoListPage;
    }

}
