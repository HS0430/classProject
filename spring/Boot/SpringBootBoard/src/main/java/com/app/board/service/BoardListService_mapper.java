package com.app.board.service;

import com.app.board.domain.BoardArticleDTO;
import com.app.board.domain.BoardListPage;
import com.app.board.domain.BoardListPage_mapper;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListService_mapper {

    @Autowired
    private BoardMapper boardMapper;


    public BoardListPage_mapper getPage(int pageNum){

        // 게시물의 리스트
        List<BoardArticleDTO> list = boardMapper.selectList((pageNum-1)*10, 10);

        // 전체 게시물의 개수
        int totalCount = boardMapper.totalCount();

        BoardListPage_mapper boardListPage_mapper = new BoardListPage_mapper(10, pageNum, list, totalCount);

        return boardListPage_mapper;
    }

    public List<BoardArticleDTO> getList(int pageNum){

        int index = (pageNum-1)*10;  // 1->0, 2->10, 3->20, 4->30
        int count = 10;

        return boardMapper.selectList(index,count);

    }

}