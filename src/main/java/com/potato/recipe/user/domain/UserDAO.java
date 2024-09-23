package com.potato.recipe.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDAO {
    @Id
    UUID id;
    String userName;
    String password;
}
