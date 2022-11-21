package com.firstcoding.todo_spring.service;

import com.firstcoding.todo_spring.dao.TodoDao;
import com.firstcoding.todo_spring.dao.TodoDaoImpl;
import com.firstcoding.todo_spring.domain.Todo_Spring;
import com.firstcoding.todo_spring.util.ConnectionProvider;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Log4j2
@Service
public class TodoService {

    @Autowired
    private TodoDao dao;

    public List<Todo_Spring> selectTodoList(){
        List<Todo_Spring> list = null;

        try {
            @Cleanup Connection conn = ConnectionProvider.getInstance().getConnection();
            list = dao.selectTodoList(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int insertTodo(Todo_Spring todo){
        int result = 0;
        Connection conn = null;
        try {
            conn = ConnectionProvider.getInstance().getConnection();
            result = dao.insertTodo(conn, todo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
