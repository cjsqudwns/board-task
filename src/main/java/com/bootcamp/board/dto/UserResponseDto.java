package com.bootcamp.board.dto;

public record UserResponseDto(
        Long uid,
        String name,
        String email
) {}