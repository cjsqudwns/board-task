package com.bootcamp.board.dto.response;

import com.bootcamp.board.dto.PostDto;
import com.bootcamp.board.entity.constant.CategoryType;

import java.time.LocalDateTime;

public record PostResponse(
        Long pid,
        String title,
        String content,
        CategoryType categoryType,
        LocalDateTime createdDate,
        String createdBy
) {
    // of 메서드는 record에서도 동일하게 정의 가능
    public static PostResponse of(Long pid, String title, String content, CategoryType categoryType, LocalDateTime createdDate, String createdBy) {
        return new PostResponse(pid, title, content, categoryType, createdDate, createdBy);
    }

    // from 메서드도 마찬가지로 사용 가능
    public static PostResponse from(PostDto postDto) {
        return PostResponse.of(postDto.getId(), postDto.getTitle(), postDto.getContent(), postDto.getCategoryType(), postDto.getCreatedDate(), postDto.getCreatedBy());
    }
}
