package com.cognitive.cogdemver.services;

import com.cognitive.cogdemver.entities.Role;
import com.cognitive.cogdemver.models.dto.RegistrationDTO;
import com.cognitive.cogdemver.entities.User;
import com.cognitive.cogdemver.repositories.UserRepository;
import com.cognitive.cogdemver.utils.ServiceUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByUsername(String username) {
        return findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User with username " + username + " not found"));
    }

    @Override
    public User getByEmail(String email) {
        return findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User with email " + email + " not found"));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User create(RegistrationDTO dto) {
        return new User()
                .setUsername(dto.getUsername())
                .setEmail(dto.getEmail())
                .setPassword(encoder.encode(dto.getPassword()))
                .setActive(true)
                .setRole(Role.USER.getAuthority())
                .setUuid(ServiceUtil.generateUuid())
                .setDateOfCreate(LocalDate.now());
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return findByUsername(authentication.getName())
                .orElseThrow(() -> new EntityNotFoundException("User with username " + authentication.getName() + " not found"));
    }
}
