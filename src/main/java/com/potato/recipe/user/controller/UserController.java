package com.potato.recipe.user.controller;

import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestLoginDTO;
import com.potato.recipe.user.domain.dto.RequestSignUpDTO;
import com.potato.recipe.user.domain.dto.RequestUserDuplicateDTO;
import com.potato.recipe.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/auth")
@RestController
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 아이디 중복 검사
    @PostMapping("/duplicate")
    public ResponseEntity<Map<String, Object>> duplicate(@RequestBody RequestUserDuplicateDTO requestUserDuplicateDTO) {
        Boolean isSuccess = userService.duplicate(requestUserDuplicateDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", isSuccess);
        responseMap.put("message", isSuccess ? "사용할 수 있는 아이디입니다." : "이미 있는 아이디입니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody RequestSignUpDTO requestSignUpDTO) {
        Boolean isSuccess = userService.signUp(requestSignUpDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", isSuccess);
        responseMap.put("message", isSuccess ? "계정이 성공적으로 생성되었습니다." : "비밀번호가 보안 기준에 적합하지 않습니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody RequestLoginDTO requestLoginDTO) {
        UserDAO userDAO = userService.login(requestLoginDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", userDAO != null);
        responseMap.put("message", userDAO != null ? "로그인에 성공했습니다." : "아이디 혹은 비밀번호가 다릅니다.");
        responseMap.put("userId", userDAO != null ? userDAO.getId() : "00000000-0000-0000-0000-000000000000");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logout() {
        // 세션 추가 후 작업 진행 예정
        Boolean isSuccess = true;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", isSuccess);
        responseMap.put("message", isSuccess ? "로그아웃 성공했습니다." : "로그아웃에 실패했습니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}
