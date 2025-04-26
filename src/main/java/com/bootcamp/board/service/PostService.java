package com.bootcamp.board.service;

import com.bootcamp.board.dto.PostDto;
import com.bootcamp.board.entity.Post;
import com.bootcamp.board.entity.User;
import com.bootcamp.board.repository.PostRepository;
import com.bootcamp.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<PostDto> getPosts() {
        return postRepository.findAll().stream()
                .map(PostDto::from)
                .toList();
    }

    public PostDto getPost(Long pid) {
        Post post = postRepository.findById(pid).orElseThrow(() -> new IllegalArgumentException("해당 Post는 존재하지 않습니다."));
        return PostDto.from(post);
    }

    @Transactional
    public void registerPost(PostDto postDto) {

        // User Entity
        User user = userRepository.getReferenceById(postDto.getUserDto().getUid());

        // Post Entity
        Post post = postDto.toEntity(user);

        postRepository.save(post);
    }

    public void updatePost(Long pid, PostDto postDto) {

    }

    public void deletePost(long pid, String uid) {


    }

}
