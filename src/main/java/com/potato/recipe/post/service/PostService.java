package com.potato.recipe.post.service;

import com.potato.recipe.post.bean.*;
import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestDeletePostDTO;
import com.potato.recipe.post.domain.dto.RequestSavePostDTO;
import com.potato.recipe.post.domain.dto.RequestUpdatePostDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    private final SavePostBean savePostBean;
    private final UpdatePostBean updatePostBean;
    private final DeletePostBean deletePostBean;
    private final GetPostBean getPostBean;
    private final GetPostAllBean getPostAllBean;

    public PostService (SavePostBean savePostBean,
                        UpdatePostBean updatePostBean,
                        DeletePostBean deletePostBean,
                        GetPostBean getPostBean,
                        GetPostAllBean getPostAllBean) {
        this.savePostBean = savePostBean;
        this.updatePostBean = updatePostBean;
        this.deletePostBean = deletePostBean;
        this.getPostBean = getPostBean;
        this.getPostAllBean = getPostAllBean;
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

    public PostDAO getPost(UUID recipeId) {
        return getPostBean.exec(recipeId);
    }

    public List<PostDAO> getPostAll() {
        return getPostAllBean.exec();
    }
}
