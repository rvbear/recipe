package com.potato.recipe.post.domain;

import com.potato.recipe.post.other.ListStringConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PostDAO {
    @Id
    UUID id;
    UUID userId;
    String thumbnail;
    String title;
    String description;

    @Convert(converter = ListStringConverter.class)
    List<Map<String, Object>> ingredient;
    @Convert(converter = ListStringConverter.class)
    List<Map<String, Object>> instructions;
}
