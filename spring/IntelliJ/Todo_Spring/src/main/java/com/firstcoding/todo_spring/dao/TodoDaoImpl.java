package com.firstcoding.todo_spring.dao;

import com.firstcoding.todo_spring.domain.Todo_Spring;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
public class TodoDaoImpl implements TodoDao {

    @Override
    public List<Todo_Spring> selectTodoList(Connection conn) throws SQLException {
        List<Todo_Spring> list = null;
        String sql = "SELECT * FROM tbl_todo";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        if (rs.next()){
            list = new ArrayList<>();
            do {
                list.add(
                        Todo_Spring.builder()
                                .tno(rs.getLong(1))
                                .todo(rs.getString(2))
                                .dueDate(rs.getDate(3).toLocalDate())
                                .finished(rs.getBoolean(4))
                                .build()
                );
            } while (rs.next());
        } else {
            // 비어 있는 리스트 생성 : null 값으로 반화할 경우 상황에 따라 null 비교하는 구문이 필요!!
            list = Collections.emptyList();;
        }

        log.info(list);
        return list;
    }

    @Override
    public int insertTodo(Connection conn, Todo_Spring todo) throws SQLException {
        int result = 0;

        String sql = "INSERT INTO tbl_todo (todo, dueDate) VALUES(?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todo.getTodo());
        pstmt.setDate(2, Date.valueOf(todo.getDueDate()));

        result = pstmt.executeUpdate();

        return result;
    }


}
