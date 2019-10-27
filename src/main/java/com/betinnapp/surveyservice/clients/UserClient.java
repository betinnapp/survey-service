package com.betinnapp.surveyservice.clients;

import com.betinnapp.surveyservice.model.user.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface UserClient {

    @RequestLine("GET /user/me")
    @Headers("authorization: {token}")
    User getUserInfo(@Param("token") String token);
}
