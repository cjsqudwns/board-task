package com.bootcamp.board.service;

import com.bootcamp.board.model.User;
import com.bootcamp.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 로그인 처리: 아이디와 비밀번호가 일치하는 사용자 반환
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);  // 유저가 존재하는지 확인
        if (user != null && user.getPassword().equals(password)) {  // 비밀번호 확인
            return user;
        }
        return null;  // 로그인 실패 시 null 반환
    }

    // 회원가입 처리
    public boolean register(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return false;  // 이미 존재하는 유저가 있을 경우 실패
        }
        userRepository.save(user);  // 새로운 유저 저장
        return true;
    }

    // 회원 정보 수정 처리
    public void updateUser(User user) {
        userRepository.save(user);  // 수정된 정보를 저장
    }

    // 회원 탈퇴 처리
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);  // 유저 삭제
    }
}
