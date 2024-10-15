package com.potato.recipe.post.bean.small;

import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPostDAOBean {
    private final PostRepository postRepository;

    public GetPostDAOBean(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDAO exec(UUID id) {
        PostDAO postDAO = postRepository.findById(id).orElse(null);
        if(postDAO == null) return null;

        return postDAO.getIsDeleted() ? null : postDAO;
    }
}
