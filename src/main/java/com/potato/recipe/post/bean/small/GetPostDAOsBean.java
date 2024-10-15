package com.potato.recipe.post.bean.small;

import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.repository.PostRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPostDAOsBean {
    private final PostRepository postRepository;

    public GetPostDAOsBean(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDAO> exec() {
        return postRepository.findAll();
    }
}
