package com.bootcamp.board.service;

import com.bootcamp.board.model.Board;
import com.bootcamp.board.model.User;
import com.bootcamp.board.repository.BoardRepository;
import com.bootcamp.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    // 글 목록 조회
    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    // 특정 글 상세 조회
    public Board getBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 존재하지 않습니다. id=" + id));
    }

    // 글 저장
    public boolean saveBoard(Board board, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + userId));
        board.setUser(user);
        Board saved = boardRepository.save(board);
        return saved.getBid() != null;
    }
}
