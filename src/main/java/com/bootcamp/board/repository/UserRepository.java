package com.bootcamp.board.repository;

import com.bootcamp.board.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 유저 찾기
    User findByEmail(String email);
}
