package com.potato.recipe.post.bean.small;

import com.potato.recipe.post.domain.PostDAO;
import org.springframework.stereotype.Component;

@Component
public class DeletePostDAOBean {
    public PostDAO exec(PostDAO postDAO) {
        postDAO.setIsDeleted(true);

        return postDAO;
    }
}
