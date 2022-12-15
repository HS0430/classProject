package com.app.board.Repository;

import com.app.board.Entity.Board;
import com.app.board.domain.BoardArticleDTO;
import com.app.board.domain.BoardDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Query("SELECT b FROM Board b")
    List<Board> selectAll();

    @Query(value = "SELECT b FROM Board b ORDER BY b.bno DESC")
//    @Select("select *, (select count(*) from tbl_reply r  where r.bno=b.bno) as replycnt from tbl_board b order by b.bno desc limit #{start},#{count}")
    List<Board> selectList();

    @Query("SELECT COUNT(b) FROM Board b")
    Integer totalCount();

    // 게시글 하나의 정보
    @Query("SELECT b FROM Board b WHERE b.bno=?1")
    Board selectByBno(int bno);

    @Transactional
    @Modifying
    @Query("delete from Board b where b.bno = ?1")
    int deleteByBno(Integer bno);



//    @Query(value = "SELECT b, (SELECT COUNT(r) FROM Reply r WHERE r.bno=b.bno) AS replycnt FROM Board b")
//    List<Object[]> selectListTest();

//    @Insert("INSERT INTO tbl_board (title, content, writer, photo) VALUES (#{title}, #{content}, #{writer}, #{photo})")
//    Integer insert(BoardDTO boardDTO) throws SQLException;

//    @Delete("DELETE FROM tbl_board WHERE bno=#{bno}")
//    Integer deleteByBno(int bno);

//    @Update("UPDATE tbl_board SET title=#{title}, content=#{content}, writer=#{writer}, photo=#{photo}, updatedate=NOW() WHERE bno=#{bno}")
//    Integer update(BoardDTO boardDTO) throws SQLException;
}
