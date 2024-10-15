package com.potato.recipe.post.service;

import com.potato.recipe.post.bean.SavePostBean;
import com.potato.recipe.post.domain.PostDAO;
import com.potato.recipe.post.domain.dto.RequestSavePostDTO;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final SavePostBean savePostBean;

    public PostService (SavePostBean savePostBean) {
        this.savePostBean = savePostBean;
    }

    public PostDAO savePost(RequestSavePostDTO requestSavePostDTO) {
        return savePostBean.exec(requestSavePostDTO);
    }
}
