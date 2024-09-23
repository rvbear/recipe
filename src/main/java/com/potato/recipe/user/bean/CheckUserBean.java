package com.potato.recipe.user.bean;

import com.potato.recipe.user.bean.small.GetUserDAOBean;
import com.potato.recipe.user.domain.dto.RequestUserDuplicateDTO;
import org.springframework.stereotype.Component;

@Component
public class CheckUserBean {
    private final GetUserDAOBean getUserDAOBean;

    public CheckUserBean(GetUserDAOBean getUserDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
    }

    public Boolean exec(RequestUserDuplicateDTO requestUserDuplicateDTO) {
        return getUserDAOBean.exec(requestUserDuplicateDTO.getUserName()) == null;
    }
}
