package com.potato.recipe.post.bean;

import com.potato.recipe.post.bean.small.GetPostDAOsBean;
import com.potato.recipe.post.domain.PostDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetPostAllByUserIdBean {
    private final GetPostDAOsBean getPostDAOsBean;

    public GetPostAllByUserIdBean(GetPostDAOsBean getPostDAOsBean) {
        this.getPostDAOsBean = getPostDAOsBean;
    }

    public List<PostDAO> exec(UUID userId) {
        return getPostDAOsBean.exec(userId);
    }
}
