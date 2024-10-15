package com.potato.recipe.post.bean;

import com.potato.recipe.post.bean.small.GetPostDAOsBean;
import com.potato.recipe.post.domain.PostDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPostAllBean {
    private final GetPostDAOsBean getPostDAOsBean;

    public GetPostAllBean(GetPostDAOsBean getPostDAOsBean) {
        this.getPostDAOsBean = getPostDAOsBean;
    }

    public List<PostDAO> exec() {
        return getPostDAOsBean.exec();
    }
}
