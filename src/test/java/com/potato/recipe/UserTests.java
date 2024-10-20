package com.potato.recipe;

import com.potato.recipe.user.bean.CheckUserBean;
import com.potato.recipe.user.bean.GetUserBean;
import com.potato.recipe.user.bean.SaveUserBean;
import com.potato.recipe.user.domain.UserDAO;
import com.potato.recipe.user.domain.dto.RequestLoginDTO;
import com.potato.recipe.user.domain.dto.RequestSignUpDTO;
import com.potato.recipe.user.domain.dto.RequestUserDuplicateDTO;
import com.potato.recipe.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserTests {
    private CheckUserBean checkUserBean;
    private SaveUserBean saveUserBean;
    private GetUserBean getUserBean;
    private UserService userService;

    @BeforeEach
    void setUp() {
        checkUserBean = mock(CheckUserBean.class);
        saveUserBean = mock(SaveUserBean.class);
        getUserBean = mock(GetUserBean.class);
        userService = new UserService(checkUserBean, saveUserBean, getUserBean);
    }

    @Test
    void testDuplicate_whenUserIsDuplicate() {
        RequestUserDuplicateDTO request = new RequestUserDuplicateDTO("testUsername");
        when(checkUserBean.exec(request)).thenReturn(true);

        Boolean result = userService.duplicate(request);

        assertTrue(result);
        verify(checkUserBean).exec(request);
    }

    @Test
    void testDuplicate_whenUserIsNotDuplicate() {
        RequestUserDuplicateDTO request = new RequestUserDuplicateDTO("testUsername");
        when(checkUserBean.exec(request)).thenReturn(false);

        Boolean result = userService.duplicate(request);

        assertFalse(result);
        verify(checkUserBean).exec(request);
    }

    @Test
    void testSignUp() {
        RequestSignUpDTO request = new RequestSignUpDTO("testUsername", "password");
        when(saveUserBean.exec(request)).thenReturn(true);

        Boolean result = userService.signUp(request);

        assertTrue(result);
        verify(saveUserBean).exec(request);
    }

    @Test
    void testLogin() {
        RequestLoginDTO request = new RequestLoginDTO("testUsername", "password");
        UserDAO expectedUser = new UserDAO(UUID.randomUUID(), "testUsername", "password");
        when(getUserBean.exec(request)).thenReturn(expectedUser);

        UserDAO result = userService.login(request);

        assertEquals(expectedUser, result);
        verify(getUserBean).exec(request);
    }
}
