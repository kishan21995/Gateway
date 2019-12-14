package com.app.gateway.retrofit;



import com.app.gateway.models.login.LoginRequest;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.models.signup.SignupRequest;
import com.app.gateway.models.signup.SignupResponse;

import retrofit2.Callback;

public class RestClient {

    private  static final  String TAG="RestClient";

    public static void loginUser(LoginRequest loginRequest, Callback<LoginResponse> callback) {
        RetrofitClient.getClient().loginUser(loginRequest).enqueue(callback);
    }

    public static void signupUser(SignupRequest signUpRequest, Callback<SignupResponse> callback) {
        RetrofitClient.getClient().signupUser1(signUpRequest).enqueue(callback);
    }








}



