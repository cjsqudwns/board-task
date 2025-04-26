package com.bootcamp.board.controller;

import com.bootcamp.board.dto.PostCommentDto;
import com.bootcamp.board.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class PostCommentController {

    private final PostCommentService postCommentService;


    @PostMapping
    public String registerNewPostComment(PostCommentDto postCommentDto) {
        return "";
    }

    @DeleteMapping("/{pcid}")
    public String deletePostComment(@PathVariable Long pcid) {
        return "";
    }
}