package com.app.gateway.retrofit;



import com.app.gateway.models.login.LoginRequest;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.models.signup.RegistrationRequests;
import com.app.gateway.models.signup.RegistrationResponses;

import retrofit2.Callback;

public class RestClient {

    private  static final  String TAG="RestClient";

    public static void loginUser(LoginRequest loginRequest, Callback<LoginResponse> callback) {
        RetrofitClient.getClient().loginUser1(loginRequest).enqueue(callback);
    }

    public static void signupUser(RegistrationRequests registrationRequests, Callback<RegistrationResponses> callback) {
        RetrofitClient.getClient().signupUser1(registrationRequests).enqueue(callback);
    }








}



