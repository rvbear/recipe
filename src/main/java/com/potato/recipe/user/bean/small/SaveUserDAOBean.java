package com.potato.recipe.user.bean.small;

import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.repository.UserDAORepository;
import org.springframework.stereotype.Component;

@Component
public class SaveUserDAOBean {
    private final UserDAORepository userDAORepository;

    public SaveUserDAOBean(UserDAORepository userDAORepository) {
        this.userDAORepository = userDAORepository;
    }

    public void exec(UserDAO userDAO) {
        userDAORepository.save(userDAO);
    }
}
