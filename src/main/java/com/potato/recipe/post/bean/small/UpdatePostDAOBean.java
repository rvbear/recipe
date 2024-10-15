package com.potato.recipe.post.bean.small;

import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestUpdatePostDTO;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostDAOBean {

    public PostDAO exec(PostDAO postDAO, RequestUpdatePostDTO requestUpdatePostDTO) {
        postDAO.setTitle(requestUpdatePostDTO.getTitle());
        postDAO.setDescription(requestUpdatePostDTO.getDescription());
        postDAO.setThumbnail(requestUpdatePostDTO.getThumbnail());
        postDAO.setInstructions(requestUpdatePostDTO.getInstructions());
        postDAO.setIngredient(requestUpdatePostDTO.getIngredient());

        return postDAO;
    }
}
