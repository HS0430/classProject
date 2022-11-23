package com.firstcoding.todo_spring.dao;

import com.firstcoding.todo_spring.domain.Todo_Spring;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
@Repository
public class TodoDaoImpl implements TodoDao {

    @Override
    public List<Todo_Spring> selectTodoList(Connection conn) throws SQLException {
        List<Todo_Spring> list = null;
        String sql = "SELECT * FROM tbl_todo";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();


        list = new ArrayList<>();
        while (rs.next()) {
            list.add(
                    Todo_Spring.builder()
                            .tno(rs.getLong(1))
                            .todo(rs.getString(2))
                            .dueDate(rs.getDate(3).toLocalDate())
                            .finished(rs.getBoolean(4))
                            .build()
            );
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

    @Override
    public Todo_Spring selectByTno(Connection conn, long tno) throws SQLException {

        @Cleanup PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM tbl_todo WHERE tno=?");
        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        Todo_Spring todoDTO = null;

        if(rs.next()){
            todoDTO = new Todo_Spring(
                    rs.getLong(1),
                    rs.getString(2),
                    rs.getDate(3).toLocalDate(),
                    rs.getBoolean(4)
                    );
        }

        return todoDTO;
    }

    @Override
    public int updateTodo(Connection conn, Todo_Spring dto) throws SQLException {
        int result = 0;
        log.info("todo update ...");
        String sql = "UPDATE tbl_todo SET todo=?, duedate=?, finished=? WHERE tno=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, dto.getTodo());
        pstmt.setDate(2, Date.valueOf(dto.getDueDate()));
        pstmt.setBoolean(3, dto.isFinished());
        pstmt.setLong(4, dto.getTno());

        result = pstmt.executeUpdate();

        return result;
    }

    @Override
    public int deleteTodo(Connection conn, long tno) throws SQLException {
        int result = 0;
        log.info("todo delete ...");
        String sql = "DELETE FROM tbl_todo WHERE tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, tno);

        result = pstmt.executeUpdate();

        return result;
    }


}
