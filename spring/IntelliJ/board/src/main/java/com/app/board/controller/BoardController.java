package com.app.board.controller;

import com.app.board.domain.Board;
import com.app.board.domain.Paging;
import com.app.board.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/listGet")
    @ResponseBody
    public Map<String, Object> boardListGet(Model model, HttpServletRequest req){
        Map<String, Object> map = new HashMap<String, Object>();

        log.info("board List...");

        String searchType = req.getParameter("searchType");
        String keyword = req.getParameter("keyword");

        int reqPage = req.getParameter("page") == null ? 0 : Integer.parseInt(req.getParameter("page"));
        int page = req.getParameter("page") == null ? 0 : ((Integer.parseInt(req.getParameter("page"))-1)*10);
        int totalCount = boardService.getTotalCount(searchType, keyword);
        log.info(searchType);
        log.info(keyword);
        log.info(totalCount);
        log.info(page);
        Paging paging = new Paging();
        paging.setPageNo(reqPage);
        paging.setPageSize(10);
        paging.setTotalCount(totalCount);

        log.info(paging);

        List<Board> list = new ArrayList<>();
        list = boardService.listBoard(page, paging.getPageSize(), searchType, keyword);
        map.put("bList", list);
        map.put("paging", paging);
//        model.addAttribute("boardlist", boardService.listBoard(page, paging.getPageSize()));
//        model.addAttribute("paging", paging);

        return map;
    }

    @GetMapping("/list")
    public String boardList(Model model, HttpServletRequest req){
        log.info("board List View...");


        int reqPage = req.getParameter("page") == null ? 0 : Integer.parseInt(req.getParameter("page"));
        int page = req.getParameter("page") == null ? 0 : ((Integer.parseInt(req.getParameter("page"))-1)*10);
//        int totalCount = boardService.getTotalCount();
//        log.info(totalCount);
//        log.info(page);
//        Paging paging = new Paging();
//        paging.setPageNo(reqPage);
//        paging.setPageSize(10);
//        paging.setTotalCount(totalCount);

//        log.info(paging);

//        model.addAttribute("boardlist", boardService.listBoard(page, paging.getPageSize()));
//        model.addAttribute("paging", paging);

        return "/board/list";
    }

    @GetMapping("/reg")
    public String regBoardView(){
        return "/board/reg";
    }

    @PostMapping("/reg")
    public String regBoard(Board board){
        log.info(board);
        boardService.regBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/modify")
    public String modifyBoardView(Model model, @RequestParam("bno") int bno){
        model.addAttribute("board", boardService.getBoard(bno));
        return "/board/modify";
    }

    @PostMapping("/modify")
    public String modifyBoard(Board board){
        boardService.modifyBoard(board);
        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String deleteBoard(@RequestParam("bno") int bno){
        boardService.deleteBoard(bno);
        return "redirect:/board/list";
    }

}
