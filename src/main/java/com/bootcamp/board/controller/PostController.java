package com.bootcamp.board.controller;

import com.bootcamp.board.dto.PostDto;
import com.bootcamp.board.dto.PostRequestDto;
import com.bootcamp.board.dto.UserDto;
import com.bootcamp.board.dto.response.PostResponse;
import com.bootcamp.board.entity.constant.CategoryType;
import com.bootcamp.board.entity.constant.UserRoleType;
import com.bootcamp.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/posts")
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping
    public String getPosts(ModelMap map) {

        List<PostResponse> posts = postService.getPosts().stream()
                .map(PostResponse::from)
                .toList();

        map.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/form")
    public String postFormPage() {
        return "posts/form";
    }

    @GetMapping("/{pid}")
    public String getPostsByPid(@PathVariable Long pid, ModelMap map) {

        PostResponse post = PostResponse.from(postService.getPost(pid));

        map.addAttribute("post", post);

        return "posts/detail";
    }

    @PostMapping
    public String registerPosts(PostRequestDto postRequestDto) {

        UserDto userDto = UserDto.of("admin",
                "admin",
                "admin",
                "admin@board.com",
                UserRoleType.ADMIN);
        // request -> postDto
        PostDto postDto = PostDto.of(postRequestDto.getTitle(),
                postRequestDto.getContent(),
                CategoryType.BACKEND,
                userDto);

        postService.registerPost(postDto);

        return "redirect:/posts";
    }

    @PutMapping
    public String updatePosts() {
        return "";
    }

    @DeleteMapping("/{uid}")
    public String deletePostsByPid() {
        return "";
    }
}