package com.potato.recipe.user.domain.dto;

import lombok.Data;

@Data
public class RequestLoginDTO {
    String userName;
    String password;
}
