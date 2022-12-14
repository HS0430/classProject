package com.app.board.service.board.old;

import com.app.board.domain.BoardDTO;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardViewService_mapper {

    @Autowired
    private BoardMapper boardMapper;

    public BoardDTO selectBoardDTO(int bno){
        return boardMapper.selectByBno(bno);
    }
}
