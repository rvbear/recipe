package com.potato.recipe.post.bean;

import com.potato.recipe.post.bean.small.GetPostDAOBean;
import com.potato.recipe.post.bean.small.SavePostDAOBean;
import com.potato.recipe.post.bean.small.UpdatePostDAOBean;
import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestUpdatePostDTO;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostBean {
    private final GetPostDAOBean getPostDAOBean;
    private final UpdatePostDAOBean updatePostDAOBean;
    private final SavePostDAOBean savePostDAOBean;

    public UpdatePostBean(GetPostDAOBean getPostDAOBean, UpdatePostDAOBean updatePostDAOBean, SavePostDAOBean savePostDAOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.updatePostDAOBean = updatePostDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    public PostDAO exec(RequestUpdatePostDTO requestUpdatePostDTO) {
        PostDAO postDAO = getPostDAOBean.exec(requestUpdatePostDTO.getRecipeId());
        if(postDAO == null) return null;

        PostDAO updatePostDAO = updatePostDAOBean.exec(postDAO, requestUpdatePostDTO);

        savePostDAOBean.exec(updatePostDAO);

        return getPostDAOBean.exec(postDAO.getId());
    }
}