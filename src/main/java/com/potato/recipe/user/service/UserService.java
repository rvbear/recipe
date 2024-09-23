package com.potato.recipe.user.service;

import com.potato.recipe.user.bean.CheckUserBean;
import com.potato.recipe.user.bean.GetUserBean;
import com.potato.recipe.user.bean.SaveUserBean;
import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestLoginDTO;
import com.potato.recipe.user.domain.dto.RequestSignUpDTO;
import com.potato.recipe.user.domain.dto.RequestUserDuplicateDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final CheckUserBean checkUserBean;
    private final SaveUserBean saveUserBean;
    private final GetUserBean getUserBean;

    public UserService(CheckUserBean checkUserBean, SaveUserBean saveUserBean, GetUserBean getUserBean) {
        this.checkUserBean = checkUserBean;
        this.saveUserBean = saveUserBean;
        this.getUserBean = getUserBean;
    }

    // 아이디 중복확인
    public Boolean duplicate(RequestUserDuplicateDTO requestUserDuplicateDTO) {
        return checkUserBean.exec(requestUserDuplicateDTO);
    }

    // 회원가입
    public Boolean signUp(RequestSignUpDTO requestSignUpDTO) {
        return saveUserBean.exec(requestSignUpDTO);
    }

    // 로그인
    public UserDAO login(RequestLoginDTO requestLoginDTO) {
        return getUserBean.exec(requestLoginDTO);
    }
}
