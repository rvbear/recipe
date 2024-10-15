package com.potato.recipe.post.bean;

import com.potato.recipe.post.bean.small.CreatePostDAOBean;
import com.potato.recipe.post.bean.small.GetPostDAOBean;
import com.potato.recipe.post.bean.small.SavePostDAOBean;
import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestSavePostDTO;
import org.springframework.stereotype.Component;

@Component
public class SavePostBean {
    private final CreatePostDAOBean createPostDAOBean;
    private final SavePostDAOBean savePostDAOBean;
    private final GetPostDAOBean getPostDAOBean;

    public SavePostBean(CreatePostDAOBean createPostDAOBean, SavePostDAOBean savePostDAOBean, GetPostDAOBean getPostDAOBean) {
        this.createPostDAOBean = createPostDAOBean;
        this.savePostDAOBean = savePostDAOBean;
        this.getPostDAOBean = getPostDAOBean;
    }

    public PostDAO exec(RequestSavePostDTO requestSavePostDTO) {
        PostDAO postDAO = createPostDAOBean.exec(requestSavePostDTO);

        savePostDAOBean.exec(postDAO);

        return getPostDAOBean.exec(postDAO.getId());
    }

}