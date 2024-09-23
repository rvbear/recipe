package com.potato.recipe.user.controller;

import com.potato.recipe.user.domain.dto.RequestSignUpDTO;
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

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody RequestSignUpDTO requestSignUpDTO) {
        Boolean isSuccess = userService.signUp(requestSignUpDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", isSuccess);
        responseMap.put("message", isSuccess ? "계정이 성공적으로 생성되었습니다." : "비밀번호가 보안 기준에 적합하지 않습니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}
