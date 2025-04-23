package com.bootcamp.board.controller;

import com.bootcamp.board.model.User;
import com.bootcamp.board.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.login(username, password);

        if (user != null) {
            // 로그인 성공 시, 세션에 유저 정보 저장
            session.setAttribute("loginUser", user);
            return "redirect:/board/list";  // 로그인 성공 후 게시글 목록 페이지로 이동
        } else {
            // 로그인 실패 시, 에러 메시지 추가
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "user/login";  // 로그인 페이지로 다시 이동
        }
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 로그인 정보 제거
        session.invalidate();
        return "redirect:/board/list";  // 로그아웃 후 게시글 목록 페이지로 이동
    }

    // 회원가입 페이지로 이동
    @GetMapping("/register")
    public String registerPage() {
        return "user/register";  // 회원가입 페이지로 리턴
    }

    // 회원가입 처리
    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password, @RequestParam String name, Model model) {
        // 서비스에서 회원가입 처리
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);

        boolean isRegistered = userService.register(user);

        if (isRegistered) {
            return "redirect:/user/login";  // 회원가입 성공 후 로그인 페이지로 리디렉션
        } else {
            model.addAttribute("error", "회원가입에 실패했습니다.");
            return "user/register";  // 실패 시 회원가입 페이지로 돌아가기
        }
    }

    // 회원 정보 수정 페이지로 이동
    @GetMapping("/edit")
    public String editPage(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/user/login";  // 로그인하지 않은 경우 로그인 페이지로 리디렉션
        }
        model.addAttribute("user", loginUser);
        return "user/edit";  // 회원 정보 수정 페이지로 리턴
    }

    // 회원 정보 수정 처리
    @PostMapping("/edit")
    public String edit(@RequestParam String email, @RequestParam String password, @RequestParam String name, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser != null) {
            loginUser.setEmail(email);
            loginUser.setPassword(password);
            loginUser.setName(name);

            userService.updateUser(loginUser);  // 회원 정보 수정 처리

            session.setAttribute("loginUser", loginUser);  // 수정된 정보로 세션 갱신
            return "redirect:/board/list";  // 수정 후 게시글 목록 페이지로 리디렉션
        } else {
            return "redirect:/user/login";  // 로그인하지 않은 경우 로그인 페이지로 리디렉션
        }
    }

    // 회원 탈퇴 처리
    @GetMapping("/delete")
    public String delete(HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser != null) {
            userService.deleteUser(loginUser.getUid());  // 회원 탈퇴 처리
            session.invalidate();  // 세션 종료
            return "redirect:/board/list";  // 탈퇴 후 게시글 목록 페이지로 리디렉션
        } else {
            return "redirect:/user/login";  // 로그인하지 않은 경우 로그인 페이지로 리디렉션
        }
    }
}
