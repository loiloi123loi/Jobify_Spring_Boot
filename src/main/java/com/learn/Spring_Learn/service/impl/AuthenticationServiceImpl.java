package com.learn.Spring_Learn.service.impl;

import com.learn.Spring_Learn.enums.AuthProvider;
import com.learn.Spring_Learn.enums.Role;
import com.learn.Spring_Learn.exception.EmailException;
import com.learn.Spring_Learn.exception.PasswordException;
import com.learn.Spring_Learn.models.User;
import com.learn.Spring_Learn.repository.UserRepository;
import com.learn.Spring_Learn.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static com.learn.Spring_Learn.constants.Messages.*;
import static com.learn.Spring_Learn.utils.RandomStringUtil.generateRandomString;
import static com.learn.Spring_Learn.utils.Template.createResponse;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Map<String, Object> registerUser(User user, String repeat_password) {
        if (user.getPassword() != null && !user.getPassword()
                                               .equals(repeat_password)) {
            throw new PasswordException(PASSWORD_NOT_MATCH);
        }
        if (userRepository.findByEmail(user.getEmail())
                          .isPresent()) {
            throw new EmailException(EMAIL_IN_USE);
        }
        user.setVerified(false);
        user.setRoles(Set.of(Role.USER));
        user.setProvider(AuthProvider.LOCAL);
        user.setActivateToken(UUID.randomUUID()
                                  .toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActivateToken(generateRandomString(50));
        userRepository.save(user);
        return createResponse(REGISTER_SUCCESSFUL);
    }
}
