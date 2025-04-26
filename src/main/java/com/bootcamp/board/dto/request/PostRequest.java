package com.bootcamp.board.dto.request;

import com.bootcamp.board.dto.PostDto;
import com.bootcamp.board.dto.UserDto;
import com.bootcamp.board.entity.constant.CategoryType;

public record PostRequest(
        String title,
        String content,
        CategoryType categoryType
) {
    public PostRequest {
        // categoryType이 null이면 기본값으로 BACKEND 설정
        if (categoryType == null) {
            categoryType = CategoryType.BACKEND;
        }
    }

    public static PostRequest of(String title, String content, CategoryType categoryType) {
        return new PostRequest(title, content, categoryType);
    }

    public PostDto toDto(UserDto userDto) {
        return PostDto.of(title, content, categoryType, userDto);
    }
}