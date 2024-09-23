package com.potato.recipe.user.service;

import com.potato.recipe.user.bean.SaveUserBean;
import com.potato.recipe.user.domain.dto.RequestSignUpDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final SaveUserBean saveUserBean;

    public UserService(SaveUserBean saveUserBean) {
        this.saveUserBean = saveUserBean;
    }

    public Boolean signUp(RequestSignUpDTO requestSignUpDTO) {
        return saveUserBean.exec(requestSignUpDTO);
    }
}
