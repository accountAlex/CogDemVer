package com.cognitive.cogdemver.services;

import com.cognitive.cogdemver.entities.User;
import com.cognitive.cogdemver.models.dto.RegistrationDTO;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User getByUsername(String username);

    User getByEmail(String email);

    void save(User user);

    User create(RegistrationDTO dto);

    User getAuthenticatedUser();
}
