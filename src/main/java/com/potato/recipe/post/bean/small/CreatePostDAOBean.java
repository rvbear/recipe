package com.potato.recipe.post.bean.small;

import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestSavePostDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreatePostDAOBean {
    public PostDAO exec(RequestSavePostDTO requestSavePostDTO) {
        return PostDAO.builder()
                .id(UUID.randomUUID())
                .title(requestSavePostDTO.getTitle())
                .description(requestSavePostDTO.getDescription())
                .thumbnail(requestSavePostDTO.getThumbnail())
                .ingredient(requestSavePostDTO.getIngredient())
                .instructions(requestSavePostDTO.getInstructions())
                .build();
    }
}
