package com.potato.recipe.user.bean.small;

import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestSignUpDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDAOBean {
    public UserDAO exec(RequestSignUpDTO requestSignUpDTO) {
        return UserDAO.builder()
                .id(UUID.randomUUID())
                .userName(requestSignUpDTO.getUserName())
                .password(requestSignUpDTO.getPassword())
                .build();
    }
}
