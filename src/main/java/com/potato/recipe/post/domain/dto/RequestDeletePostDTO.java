package com.potato.recipe.post.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestDeletePostDTO {
    UUID recipeId;
}
