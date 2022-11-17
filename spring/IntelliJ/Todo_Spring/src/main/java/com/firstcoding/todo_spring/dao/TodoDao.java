package com.firstcoding.todo_spring.dao;

import com.firstcoding.todo_spring.domain.Todo_Spring;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TodoDao {
    List<Todo_Spring> selectTodoList(Connection conn) throws SQLException;
    public int insertTodo(Connection conn, Todo_Spring todo) throws SQLException;
}
