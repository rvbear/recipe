package com.potato.recipe.post.service;

import com.potato.recipe.post.bean.SavePostBean;
import com.potato.recipe.post.bean.UpdatePostBean;
import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestSavePostDTO;
import com.potato.recipe.post.domain.dto.RequestUpdatePostDTO;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final SavePostBean savePostBean;
    private final UpdatePostBean updatePostBean;

    public PostService (SavePostBean savePostBean, UpdatePostBean updatePostBean) {
        this.savePostBean = savePostBean;
        this.updatePostBean = updatePostBean;
    }

    public PostDAO savePost(RequestSavePostDTO requestSavePostDTO) {
        return savePostBean.exec(requestSavePostDTO);
    }

    public PostDAO updatePost(RequestUpdatePostDTO requestUpdatePostDTO) {
        return updatePostBean.exec(requestUpdatePostDTO);
    }
}
