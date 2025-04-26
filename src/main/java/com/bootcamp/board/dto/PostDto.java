package com.bootcamp.board.dto;

import com.bootcamp.board.entity.Post;
import com.bootcamp.board.entity.PostComment;
import com.bootcamp.board.entity.User;
import com.bootcamp.board.entity.constant.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@ToString
@Getter
public class PostDto {
    private final Set<PostComment> postComments = new LinkedHashSet<>();
    private Long id;
    private String title;
    private String content;
    private CategoryType categoryType;
    private UserDto userDto;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime modifiedDate;
    private String modifiedBy;

    public static PostDto of(String title, String content, CategoryType categoryType, UserDto userDto) {
        return PostDto.of(null, title, content, categoryType, userDto, null, null, null, null);
    }

    public static PostDto of(Long id, String title, String content, CategoryType categoryType, UserDto userDto, LocalDateTime createdDate,
                             String createdBy, LocalDateTime modifiedDate, String modifiedBy) {
        return new PostDto(id, title, content, categoryType, userDto, createdDate, createdBy, modifiedDate, modifiedBy);
    }

    public static PostDto from(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCategoryType(),
                UserDto.from(post.getUser()),
                post.getCreatedDate(),
                post.getCreatedBy(),
                post.getModifiedDate(),
                post.getModifiedBy()
        );
    }

    public Post toEntity(User user) {
        return Post.of(
                title,
                content,
                categoryType,
                user
        );
    }

}
