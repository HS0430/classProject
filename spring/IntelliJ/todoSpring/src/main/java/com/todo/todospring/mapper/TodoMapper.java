package com.todo.todospring.mapper;

import com.todo.todospring.domain.TodoDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TodoMapper {

    List<TodoDTO> selectAll();
    TodoDTO selectByTno(long tno);
    int insertToDo(TodoDTO dto);
    int updateTodo(TodoDTO dto);
    int deleteTodo(long dto);

}