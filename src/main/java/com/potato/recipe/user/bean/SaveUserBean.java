package com.potato.recipe.user.bean;

import com.potato.recipe.user.bean.small.CreateUserDAOBean;
import com.potato.recipe.user.bean.small.GetUserDAOBean;
import com.potato.recipe.user.bean.small.SaveUserDAOBean;
import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestUserDTO;
import org.springframework.stereotype.Component;

@Component
public class SaveUserBean {
    private final CreateUserDAOBean createUserDAOBean;
    private final SaveUserDAOBean saveUserDAOBean;
    private final GetUserDAOBean getUserDAOBean;

    public SaveUserBean(CreateUserDAOBean createUserDAOBean, SaveUserDAOBean saveUserDAOBean, GetUserDAOBean getUserDAOBean) {
        this.createUserDAOBean = createUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
        this.getUserDAOBean = getUserDAOBean;
    }

    public Boolean exec(RequestUserDTO requestUserDTO) {
        UserDAO userDAO = createUserDAOBean.exec(requestUserDTO);
        saveUserDAOBean.exec(userDAO);

        return getUserDAOBean.exec(userDAO.getId()) != null;
    }
}
