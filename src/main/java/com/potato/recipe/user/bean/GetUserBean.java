package com.potato.recipe.user.bean;

import com.potato.recipe.user.bean.small.GetUserDAOBean;
import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestUserDTO;
import org.springframework.stereotype.Component;

@Component
public class GetUserBean {
    private final GetUserDAOBean getUserDAOBean;

    public GetUserBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    public UserDAO exec(RequestUserDTO requestUserDTO) {
        return getUserDAOBean.exec(requestUserDTO.getUserName(), requestUserDTO.getPassword());
    }
}
