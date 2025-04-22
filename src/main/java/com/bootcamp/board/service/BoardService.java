package com.bootcamp.board.service;

import com.bootcamp.board.model.Board;
import com.bootcamp.board.model.User;
import com.bootcamp.board.repository.BoardRepository;
import com.bootcamp.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Board getBoard(Long bid) {
        return boardRepository.findById(bid)
                .orElseThrow(() -> new IllegalArgumentException("해당 글이 존재하지 않습니다. id=" + bid));
    }

    // 글 저장
    @Transactional
    public void saveBoard(Board board, Long uid) {
        User user = userRepository.findById(uid)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + uid));
        board.setUser(user);
        Board saved = boardRepository.save(board);
    }

    // 글 수정
    public void updateBoard(Board board, Long userId) {
        User currentUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다. id=" + userId));
        Board existingBoard = boardRepository.findById(board.getBid())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id=" + board.getBid()));
        // 수정할 내용들
        existingBoard.setTitle(board.getTitle());
        existingBoard.setContent(board.getContent());
        existingBoard.setUser(currentUser);
        // JPA가 변경된 필드만 감지하여 저장함 (변경되지 않은 필드는 DB에 저장하지 않음)
        boardRepository.save(existingBoard);
    }

    // 글 삭제
    @Transactional
    public void deleteBoard(Long bid, Long uid) {
        Board board = boardRepository.findById(bid)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        if (!board.getUser().getUid().equals(uid)) {
            throw new IllegalArgumentException("삭제 권한이 없습니다.");
        }
        boardRepository.delete(board);
    }
}
