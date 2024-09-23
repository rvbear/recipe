package com.potato.recipe.user.service;

import com.potato.recipe.user.bean.GetUserBean;
import com.potato.recipe.user.bean.SaveUserBean;
import com.potato.recipe.user.bean.small.GetUserDAOBean;
import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestUserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final SaveUserBean saveUserBean;
    private final GetUserBean getUserBean;

    public UserService(SaveUserBean saveUserBean, GetUserBean getUserBean) {
        this.saveUserBean = saveUserBean;
        this.getUserBean = getUserBean;
    }

    // 회원가입
    public Boolean signUp(RequestUserDTO requestUserDTO) {
        return saveUserBean.exec(requestUserDTO);
    }

    // 로그인
    public UserDAO login(RequestUserDTO requestUserDTO) {
        return getUserBean.exec(requestUserDTO);
    }
}
