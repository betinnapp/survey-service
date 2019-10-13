package com.betinnapp.surveyservice.clients;

import com.betinnapp.surveyservice.model.user.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface UserServiceClient {

    @RequestLine("GET /me")
    @Headers("authorization: Bearer {token}")
    User getUserInfo(@Param("token") String token);
}
