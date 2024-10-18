package com.potato.recipe.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestLoginDTO {
    String userName;
    String password;
}
