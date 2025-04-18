package com.bootcamp.board.dto;

public record BoardResponseDto(
        Long bid,
        String title,
        String content,
        String writerName
) {}