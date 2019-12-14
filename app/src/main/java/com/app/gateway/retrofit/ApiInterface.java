package com.app.gateway.retrofit;



import com.app.gateway.models.login.LoginRequest;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.models.signup.SignupRequest;
import com.app.gateway.models.signup.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);


    @POST("http://api.barnco99.com/register")
    Call<SignupResponse> signupUser1(@Body SignupRequest signUpRequest);











}