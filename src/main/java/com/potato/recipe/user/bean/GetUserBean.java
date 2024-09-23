package com.potato.recipe.user.bean;

import com.potato.recipe.user.bean.small.GetUserDAOBean;
import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestLoginDTO;
import org.springframework.stereotype.Component;

@Component
public class GetUserBean {
    private final GetUserDAOBean getUserDAOBean;

    public GetUserBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    public UserDAO exec(RequestLoginDTO requestLoginDTO) {
        return getUserDAOBean.exec(requestLoginDTO.getUserName(), requestLoginDTO.getPassword());
    }
}
