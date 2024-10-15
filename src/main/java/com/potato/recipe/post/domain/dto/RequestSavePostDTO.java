package com.potato.recipe.post.domain.dto;

import com.potato.recipe.post.other.ListStringConverter;
import jakarta.persistence.Convert;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class RequestSavePostDTO {
    UUID userId;
    String thumbnail;
    String title;
    String description;

    @Convert(converter = ListStringConverter.class)
    List<Map<String, Object>> ingredient;
    @Convert(converter = ListStringConverter.class)
    List<Map<String, Object>> instructions;
}
