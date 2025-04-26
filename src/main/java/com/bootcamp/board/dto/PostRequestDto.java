package com.bootcamp.board.dto;

import com.bootcamp.board.entity.constant.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
    private CategoryType categoryType = CategoryType.BACKEND;

    public static PostRequestDto of(String title, String content, CategoryType categoryType) {
        return new PostRequestDto(title, content, categoryType);
    }

    public PostDto toDto(UserDto userDto) {
        return PostDto.of(title, content, categoryType, userDto);
    }
}
