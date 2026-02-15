package com.cvkite.cvkite_service.service;

import com.cvkite.cvkite_service.document.User;
import com.cvkite.cvkite_service.dto.AuthResponse;
import com.cvkite.cvkite_service.dto.RegisterRequest;
import com.cvkite.cvkite_service.exception.ResourceExistsException;
import com.cvkite.cvkite_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;

    public AuthResponse register(RegisterRequest request){
        log.info("Inside Auth service: register() {}", request);
        if(userRepository.existsByEmail(request.getEmail())){
            throw new ResourceExistsException("User exists");
        }

        //Adding new user to database
        User newUser = toDocument(request);

        userRepository.save(newUser);

        //TODO - send verification mail
        return toResponse(newUser);

    }

    private User toDocument(RegisterRequest request){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .profileImgUrl(request.getProfileImgUrl())
                .emailVerified(false)
                .subscriptionPlan("Basic")
                .verificationToken(UUID.randomUUID().toString())
                .verificationExpiry(LocalDateTime.now().plusHours(24))
                .build();
    }

    private AuthResponse toResponse(User newUser){
        return AuthResponse.builder()
                .id(newUser.getId())
                .name(newUser.getName())
                .email(newUser.getEmail())
                .profileImgUrl(newUser.getProfileImgUrl())
                .emailVerified(newUser.isEmailVerified())
                .subscriptionPlan(newUser.getSubscriptionPlan())
                .createdAt(newUser.getCreatedAt())
                .updatedAt(newUser.getUpdatedAt())
                .build();
    }

}
