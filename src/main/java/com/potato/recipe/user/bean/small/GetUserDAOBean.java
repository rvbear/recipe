package com.potato.recipe.user.bean.small;

import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.repository.UserDAORepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserDAOBean {
    private final UserDAORepository userDAORepository;

    public GetUserDAOBean(UserDAORepository userDAORepository) {
        this.userDAORepository = userDAORepository;
    }

    public UserDAO exec(UUID id) {
        return userDAORepository.findById(id).orElse(null);
    }

    public UserDAO exec(String userName, String password) {
        return userDAORepository.findByUserNameAndPassword(userName, password);
    }
}
