package com.potato.recipe.post.bean.small;

import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.repository.PostRepository;
import org.springframework.stereotype.Component;

@Component
public class SavePostDAOBean {
    private final PostRepository postRepository;

    public SavePostDAOBean(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void exec(PostDAO postDAO) {
        postRepository.save(postDAO);
    }
}
