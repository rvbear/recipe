package com.potato.recipe.post.controller;

import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestSavePostDTO;
import com.potato.recipe.post.domain.dto.RequestUpdatePostDTO;
import com.potato.recipe.post.domain.dto.RequestDeletePostDTO;
import com.potato.recipe.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/recipes")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 레시피 생성
    @PostMapping
    public ResponseEntity<Map<String, Object>> savePost(@RequestBody RequestSavePostDTO requestSavePostDTO) {
        PostDAO postDAO = postService.savePost(requestSavePostDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", postDAO != null);
        responseMap.put("message", postDAO != null ? "레시피 등록에 성공했습니다." : "레시피 등록에 실패했습니다.");
        responseMap.put("recipeId", postDAO != null ? postDAO.getId() : "00000000-0000-0000-0000-000000000000");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 레시피 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updatePost(@RequestBody RequestUpdatePostDTO requestUpdatePostDTO) {
        PostDAO postDAO = postService.updatePost(requestUpdatePostDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", postDAO != null);
        responseMap.put("message", postDAO != null ? "레시피 수정에 성공했습니다." : "레시피 수정에 실패했습니다.");
        responseMap.put("recipeId", postDAO != null ? postDAO.getId() : "00000000-0000-0000-0000-000000000000");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 레시피 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deletePost(@RequestBody RequestDeletePostDTO requestDeletePostDTO) {
        Boolean isSuccess = postService.deletePost(requestDeletePostDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", isSuccess);
        responseMap.put("message", isSuccess ? "레시피 삭제에 성공했습니다." : "레시피 삭제에 실패했습니다.");

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    // 레시피 상세 조회
    @GetMapping("/detail/{recipeId}")
    public ResponseEntity<Map<String, Object>> getDetailPost(@PathVariable(value = "recipeId") UUID recipeId) {
        PostDAO postDAO = postService.getDetailPost(recipeId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", postDAO != null);
        responseMap.put("message", postDAO != null ? "상세 레시피가 정상 조회되었습니다." : "상세 레시피 조회가 실패했습니다.");
        responseMap.put("recipe", postDAO);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}