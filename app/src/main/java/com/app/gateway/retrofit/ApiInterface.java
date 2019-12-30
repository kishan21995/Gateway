package com.app.gateway.retrofit;



import com.app.gateway.models.login.LoginRequests;
import com.app.gateway.models.login.LoginResponses;
import com.app.gateway.models.signup.RegistrationRequests;
import com.app.gateway.models.signup.RegistrationResponses;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })

    @GET("user/login")
    Call<LoginResponses> loginUser(@Body LoginRequests loginRequests);


    @POST("user/users")
    Call<RegistrationResponses> signupUser1(@Body RegistrationRequests registrationRequests);











}