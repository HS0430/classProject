//package com.app.board.service.board;
//
//import com.app.board.domain.BoardListPage;
//import com.app.board.entity.Board;
//import com.app.board.repository.BoardRepository;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@Log4j2
//public class BoardListService_20221220 {
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//
//    public BoardListPage getPage(int pageNum){
//
//        Pageable pageable = PageRequest.of(pageNum-1, 10, Sort.by("bno").descending());
//        Page<Board> result = boardRepository.findAll(pageable);
//        BoardListPage boardListPage = new BoardListPage(10, pageNum, result.getContent(), Long.valueOf(result.getTotalElements()).intValue());
//
//        return boardListPage;
//    }
//
//    public Page<Board> getList(int pageNum){
//
//        int count = 10;
//        Pageable pageable = PageRequest.of(pageNum-1, count, Sort.by("bno").descending());
//        Page<Board> result = boardRepository.findAll(pageable);
//
//        return result;
//
//    }
//
//}