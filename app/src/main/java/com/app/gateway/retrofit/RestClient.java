package com.app.gateway.retrofit;



import com.app.gateway.models.login.LoginRequests;
import com.app.gateway.models.login.LoginResponses;
import com.app.gateway.models.signup.RegistrationRequests;
import com.app.gateway.models.signup.RegistrationResponses;

import retrofit2.Callback;

public class RestClient {

    private  static final  String TAG="RestClient";

    public static void loginUser1(LoginRequests loginRequests, Callback<LoginResponses> callback) {
        RetrofitClient.getClient().loginUser(loginRequests).enqueue(callback);
    }

    public static void signupUser(RegistrationRequests registrationRequests, Callback<RegistrationResponses> callback) {
        RetrofitClient.getClient().signupUser1(registrationRequests).enqueue(callback);
    }








}



