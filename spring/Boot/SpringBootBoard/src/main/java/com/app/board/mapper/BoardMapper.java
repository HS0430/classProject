package com.app.board.mapper;

import com.app.board.domain.BoardArticleDTO;
import com.app.board.domain.BoardDTO;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM tbl_board")
    List<BoardDTO> selectAll();
//    @Select("SELECT @ROWNUM := @ROWNUM +1 AS rnum, b.* FROM tbl_board b, (SELECT @ROWNUM := #{param1}) tmp ORDER BY bno DESC LIMIT #{param1}, #{param2}")
//    List<BoardDTO> selectList(@Param("start") int start, @Param("count") int count);

    @Select("select *, (select count(*) from tbl_reply r  where r.bno=b.bno) as replycnt from tbl_board b order by b.bno desc limit #{start},#{count}")
    List<BoardArticleDTO> selectList(@Param("start") int start, @Param("count") int count);

    @Select("select count(*) from tbl_board")
    Integer totalCount();

    // 게시글 하나의 정보
    @Select("SELECT * FROM tbl_board WHERE bno=#{bno}")
    BoardDTO selectByBno(int bno);

    @Insert("INSERT INTO tbl_board (title, content, writer, photo) VALUES (#{title}, #{content}, #{writer}, #{photo})")
    Integer insert(BoardDTO boardDTO) throws SQLException;

    @Delete("DELETE FROM tbl_board WHERE bno=#{bno}")
    Integer deleteByBno(int bno);

    @Update("UPDATE tbl_board SET title=#{title}, content=#{content}, writer=#{writer}, photo=#{photo}, updatedate=NOW() WHERE bno=#{bno}")
    Integer update(BoardDTO boardDTO) throws SQLException;

}
