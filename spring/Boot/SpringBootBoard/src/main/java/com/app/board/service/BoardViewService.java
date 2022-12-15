package com.app.board.service;

import com.app.board.Entity.Board;
import com.app.board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardViewService {

    @Autowired
    private BoardRepository boardRepository;

    public Board selectBoardDTO(int bno){
        return boardRepository.selectByBno(bno);
    }
}
