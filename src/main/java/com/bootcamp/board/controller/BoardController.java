package com.bootcamp.board.controller;

import com.bootcamp.board.model.Board;
import com.bootcamp.board.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 글 목록 페이지
    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boardList = boardService.getBoardList();
        System.out.println(boardList);
        model.addAttribute("boards", boardList);
        return "/board/list";
    }

    // 글 작성 페이지
    @GetMapping("/write")
    public String writePage() {
        return "/board/write";
    }

    // 글 저장 기능 (POST)
    @PostMapping("/write")
    public String save(@ModelAttribute Board board, HttpSession session) {
//        Long userId = (Long) session.getAttribute("userId");
        Long userId = 1L;
        boardService.saveBoard(board, userId);
        return "redirect:/board/list";
    }

    // 글 상세보기
    @GetMapping("/view")
    public String view(@RequestParam Long id, Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "/board/view";
    }
}
