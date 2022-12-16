package com.app.board.service;

import com.app.board.Entity.Board;
import com.app.board.Repository.BoardRepository;
import com.app.board.Repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Log4j2
public class BoardDeleteService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    ReplyRepository replyRepository;

    public int delete(int bno){

        // 삭제하려는 게시물 데이터
        Board board = boardRepository.selectByBno(bno);

        int replyResult = replyRepository.deleteByBno(bno);
        int result = boardRepository.deleteByBno(bno);

        log.info("result ########################" + result);



        // 해당 게시물이 DB에서 삭제되고 해당 게시물의 사진 이름을 가지고 있다면 -> 파일을 삭제
        if(result > 0 && board.getPhoto()!=null){
            File delFile = new File(new File("").getAbsolutePath(), "photo"+File.separator+board.getPhoto());
            log.info("delFile >>>>>>>>>>>>>>>>>>>>>" + delFile);
            if(delFile.exists()){
                delFile.delete();
            }
        }
        return result;
    }

}
