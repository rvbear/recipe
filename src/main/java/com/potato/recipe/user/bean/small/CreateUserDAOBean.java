package com.potato.recipe.user.bean.small;

import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestUserDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDAOBean {
    public UserDAO exec(RequestUserDTO requestUserDTO) {
        return UserDAO.builder()
                .id(UUID.randomUUID())
                .userName(requestUserDTO.getUserName())
                .password(requestUserDTO.getPassword())
                .build();
    }
}
