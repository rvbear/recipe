package com.potato.recipe.post.bean;

import com.potato.recipe.post.bean.small.DeletePostDAOBean;
import com.potato.recipe.post.bean.small.GetPostDAOBean;
import com.potato.recipe.post.bean.small.SavePostDAOBean;
import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestDeletePostDTO;
import org.springframework.stereotype.Component;

@Component
public class DeletePostBean {
    private final GetPostDAOBean getPostDAOBean;
    private final DeletePostDAOBean deletePostDAOBean;
    private final SavePostDAOBean savePostDAOBean;

    public DeletePostBean(GetPostDAOBean getPostDAOBean, DeletePostDAOBean deletePostDAOBean, SavePostDAOBean savePostDAOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.deletePostDAOBean = deletePostDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    public Boolean exec(RequestDeletePostDTO requestDeletePostDTO) {
        PostDAO postDAO = getPostDAOBean.exec(requestDeletePostDTO.getRecipeId());
        if(postDAO == null) return false;

        PostDAO deletePostDAO = deletePostDAOBean.exec(postDAO);
        savePostDAOBean.exec(deletePostDAO);

        return true;
    }
}