package com.app.board.mapper;

import com.app.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    int regBoard(Board board);
    List<Board> listBoard(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize,
                          @Param("searchType") String searchType, @Param("keyword") String keyword);

    Board getBoard(int bno);

    int modifyBoard(Board board);

    int deleteBoard(int bno);

    int getTotalCount(@Param("searchType") String searchType, @Param("keyword") String keyword);
}
