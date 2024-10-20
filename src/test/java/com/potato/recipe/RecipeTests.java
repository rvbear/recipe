package com.potato.recipe;

import com.potato.recipe.post.bean.*;
import com.potato.recipe.post.service.PostService;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public class RecipeTests {
    private DeletePostBean deletePostBean;
    private GetPostAllBean getPostAllBean;
    private GetPostAllByUserIdBean getPostAllByUserIdBean;
    private GetPostBean getPostBean;
    private SavePostBean savePostBean;
    private UpdatePostBean updatePostBean;
    private PostService postService;

    @BeforeEach
    void setUp() {
        deletePostBean = mock(DeletePostBean.class);
        getPostAllBean = mock(GetPostAllBean.class);
        getPostAllByUserIdBean = mock(GetPostAllByUserIdBean.class);
        getPostBean = mock(GetPostBean.class);
        savePostBean = mock(SavePostBean.class);
        updatePostBean = mock(UpdatePostBean.class);
        postService = new PostService(savePostBean, updatePostBean, deletePostBean, getPostBean, getPostAllBean, getPostAllByUserIdBean);
    }

    
}
