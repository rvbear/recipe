package com.potato.recipe.post.service;

import com.potato.recipe.post.bean.DeletePostBean;
import com.potato.recipe.post.bean.GetPostBean;
import com.potato.recipe.post.bean.SavePostBean;
import com.potato.recipe.post.bean.UpdatePostBean;
import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestDeletePostDTO;
import com.potato.recipe.post.domain.dto.RequestSavePostDTO;
import com.potato.recipe.post.domain.dto.RequestUpdatePostDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {
    private final SavePostBean savePostBean;
    private final UpdatePostBean updatePostBean;
    private final DeletePostBean deletePostBean;
    private final GetPostBean getPostBean;

    public PostService (SavePostBean savePostBean, UpdatePostBean updatePostBean, DeletePostBean deletePostBean, GetPostBean getPostBean) {
        this.savePostBean = savePostBean;
        this.updatePostBean = updatePostBean;
        this.deletePostBean = deletePostBean;
        this.getPostBean = getPostBean;
    }

    public PostDAO savePost(RequestSavePostDTO requestSavePostDTO) {
        return savePostBean.exec(requestSavePostDTO);
    }

    public PostDAO updatePost(RequestUpdatePostDTO requestUpdatePostDTO) {
        return updatePostBean.exec(requestUpdatePostDTO);
    }

    public Boolean deletePost(RequestDeletePostDTO requestDeletePostDTO) {
        return deletePostBean.exec(requestDeletePostDTO);
    }

    public PostDAO getDetailPost(UUID recipeId) {
        return getPostBean.exec(recipeId);
    }
}
