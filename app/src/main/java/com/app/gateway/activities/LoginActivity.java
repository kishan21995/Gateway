package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.app.gateway.R;
import com.app.gateway.models.LoginFinalResponse;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.retrofit.RestClient;
import com.app.gateway.utils.Utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button _logBTN;
    private TextView _forgatePWD;
    private EditText _emailET,_pwdET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        _logBTN=findViewById(R.id.logBTN);
        _emailET=findViewById(R.id.emailET);
        _pwdET=findViewById(R.id.pwdET);
        _forgatePWD=findViewById(R.id.forgatePWD);


             _logBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        _forgatePWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, ForgatePasswordActivity.class);
                startActivity(intent);
            }
        });


}

}