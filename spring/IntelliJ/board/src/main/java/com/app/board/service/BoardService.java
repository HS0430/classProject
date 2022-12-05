package com.app.board.service;

import com.app.board.domain.Board;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public int regBoard(Board board){
        return boardMapper.regBoard(board);
    }

    public List<Board> listBoard(int pageNo, int pageSize, String searchType, String keyword){
        return boardMapper.listBoard(pageNo, pageSize, searchType, keyword);
    }

    public Board getBoard(int bno){
        return boardMapper.getBoard(bno);
    }

    public int modifyBoard(Board board){
        return boardMapper.modifyBoard(board);
    }

    public int deleteBoard(int bno){
        return boardMapper.deleteBoard(bno);
    }

    public int getTotalCount(String searchType, String keyword){
        return boardMapper.getTotalCount(searchType, keyword);
    }
}
