package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.gateway.R;
import com.app.gateway.models.signup.SignupRequest;
import com.app.gateway.models.signup.SignupResponse;
import com.app.gateway.retrofit.RestClient;
import com.app.gateway.utils.Utils;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private TextView _signupTXT;
    private EditText _nameET, _emailET, _mobileET, _dobET, _addressET, _pwdET;
    ;
    private Button _signupBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        _nameET = findViewById(R.id.nameET);
        _emailET = findViewById(R.id.emailET);
        _mobileET = findViewById(R.id.mobileET);


        _addressET = findViewById(R.id.addressET);
        _pwdET = findViewById(R.id.pwdET);
        _signupBTN = findViewById(R.id.signupBTN);
        _signupTXT = findViewById(R.id.signupTXT);


        _signupTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        _signupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signUpUser();
            }
        });
    }

    public  void signUpUser(){
        String user_email = _emailET.getText().toString().trim();
        String user_address = _addressET.getText().toString().trim();
        String user_mobile = _mobileET.getText().toString().trim();
        String user_pwd = _pwdET.getText().toString().trim();
        String user_name = _nameET.getText().toString().trim();








        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setAddress(user_address);
        signupRequest.setEmail(user_email);
        signupRequest.setMobile(user_mobile);
        signupRequest.setUsername(user_name);
        signupRequest.setPassword(user_pwd);




Utils.showProgressDialog(getApplicationContext(),"");
        RestClient.signupUser(signupRequest, new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
Utils.dismissProgressDialog();
                if(response != null){

                        Toast.makeText(SignupActivity.this, "success", Toast.LENGTH_SHORT).show();



                }else{
                    Toast.makeText(SignupActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Utils.dismissProgressDialog();
                Toast.makeText(SignupActivity.this, "api failure", Toast.LENGTH_SHORT).show();
            }
        });






    }
}