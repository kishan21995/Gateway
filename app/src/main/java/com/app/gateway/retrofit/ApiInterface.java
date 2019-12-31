package com.app.gateway.retrofit;



import com.app.gateway.models.login.LoginRequest;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.models.signup.RegistrationRequests;
import com.app.gateway.models.signup.RegistrationResponses;

import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })


    @POST("user/login")
    Call<LoginResponse> loginUser1(@Body LoginRequest loginRequest);


    @POST("user/users")
    Call<RegistrationResponses> signupUser1(@Body RegistrationRequests registrationRequests);











}