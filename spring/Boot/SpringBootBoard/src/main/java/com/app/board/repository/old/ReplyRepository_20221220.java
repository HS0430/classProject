//package com.app.board.repository.old;
//
//import com.app.board.entity.Reply;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//public interface ReplyRepository_20221220 extends JpaRepository<Reply, Integer> {
//    @Query("SELECT r FROM Reply r WHERE r.bno= ?1")
//    List<Reply> selectAll(Integer bno);
//
//
//    @Query("SELECT r FROM Reply r WHERE r.rno=?1")
//    Reply selectByRno(Integer rno);
//
//    @Transactional
//    @Modifying
//    @Query("delete from Reply r where r.rno = ?1")
//    int deleteByRno(int rno);
//
//    @Transactional
//    @Modifying
//    @Query("delete from Reply r where r.bno = ?1")
//    int deleteByBno(int bno);
//
//
//
////    @Insert("INSERT INTO tbl_reply (bno,reply,replyer) VALUES (#{bno}, #{reply}, #{replyer})")
////    @Options(useGeneratedKeys = true, keyProperty = "rno", keyColumn = "rno")
////    int insertReply(ReplyDTO replyDTO);
//
////    @Delete("delete from tbl_reply where rno=#{rno}")
////    int deleteByRno(int rno);
//
////    @Update("update tbl_reply set bno=#{bno}, reply=#{reply}, replyer=#{replyer}, replydate=#{replydate}, updatedate=now() where rno=#{rno} ")
////    int updateReply(ReplyDTO replyDTO);
//}
