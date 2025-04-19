package com.bootcamp.board.controller;

import com.bootcamp.board.model.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    // 글 목록 페이지
    @GetMapping("/list")
    public String list(Model model) {
        // findAll
        return "/board/list";
    }

    // 글 작성 페이지
    @GetMapping("/write")
    public String writePage() {
        return "/board/write";
    }

    // 글 저장 기능 (POST)
    @PostMapping("/write")
    public String save(@ModelAttribute Board board) {
        return "redirect:/board/list";
    }

    // 글 상세보기
    @GetMapping("/board/view?id=")
    public String view(@RequestParam Long id, Model model) {
        model.addAttribute("board");
        return "/board/view";
    }
}
