package com.rental.car.auth.service;

import com.rental.car.auth.dto.RegisterRequestDto;
import com.rental.car.auth.mapper.AuthenticationMapper;
import com.rental.car.user.model.User;
import com.rental.car.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationMapper authenticationMapper;

    public void register(RegisterRequestDto dto) {

        if (!isValid(dto)) {
            throw new IllegalArgumentException("Invalid user data");
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = authenticationMapper.toUser(dto);
        userRepository.save(user);
    }

    private boolean isValid(RegisterRequestDto dto) {
        boolean hasCompany = dto.getCompanyName() != null && !dto.getCompanyName().isBlank();
        boolean hasPerson = dto.getFirstName() != null && !dto.getFirstName().isBlank()
                && dto.getLastName() != null && !dto.getLastName().isBlank();

        return hasCompany || hasPerson;
    }

}

