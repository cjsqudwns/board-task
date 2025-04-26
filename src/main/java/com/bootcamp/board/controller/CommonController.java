package com.bootcamp.board.controller;

import com.bootcamp.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CommonController {

    private final UserService userService;

    @GetMapping({"/"})
    public String mainPage() {
        return "/index";
    }

}
