package com.betinnapp.surveyservice.service;

import com.betinnapp.surveyservice.clients.UserClient;
import com.betinnapp.surveyservice.model.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public Optional<User> getUserByToken(String token) {
        return Optional.ofNullable(userClient.getUserInfo(token));
    }
}
