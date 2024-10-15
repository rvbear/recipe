package com.potato.recipe.post.bean;

import com.potato.recipe.post.bean.small.GetPostDAOBean;
import com.potato.recipe.post.domain.PostDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPostBean {
    private final GetPostDAOBean getPostDAOBean;

    public GetPostBean(GetPostDAOBean getPostDAOBean) {
        this.getPostDAOBean = getPostDAOBean;
    }

    public PostDAO exec(UUID recipeId) {
        return getPostDAOBean.exec(recipeId);
    }
}
