package com.app.board.mapper;

import com.app.board.domain.BoardDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM tbl_board")
    List<BoardDTO> selectAll();

    @Select("SELECT * FROM tbl_board ORDER BY bno DESC LIMIT #{param1}, #{param2}")
    List<BoardDTO> selectList(@Param("start") int start, @Param("count") int count);

    @Select("select count(*) from tbl_board")
    Integer totalCount();

    @Insert("INSERT INTO tbl_board (title, content, writer, photo) VALUES (#{title}, #{content}, #{writer}, #{photo})")
    Integer insert(BoardDTO boardDTO) throws SQLException;

}
