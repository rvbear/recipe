package com.potato.recipe.post.repository;

import com.potato.recipe.post.domain.PostDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<PostDAO, UUID> {
    List<PostDAO> findAllByUserId(UUID userId);
}
