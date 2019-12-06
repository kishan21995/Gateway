package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.app.gateway.R;

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


     /*        _logBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });*/

        _forgatePWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, ForgatePasswordActivity.class);
                startActivity(intent);
            }
        });

        _logBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });

    }

    public void validation() {
        boolean check = true;
       String email = _emailET.getText().toString().trim();
       String pwd = _pwdET.getText().toString().trim();



        if (email.isEmpty()) {
            _emailET.setError("Field can't be empty");
            check = false;

        }



        if (pwd.isEmpty()) {
            _pwdET.setError("Field can't be empty");
            check = false;

        }
        if (check == true) {

            Toast.makeText(this, "Login SuccessFully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }


    }

}
