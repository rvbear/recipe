package com.potato.recipe.user.repository;

import com.potato.recipe.user.domain.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDAORepository extends JpaRepository<UserDAO, UUID> {
}
