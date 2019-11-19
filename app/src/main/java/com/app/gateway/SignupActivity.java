package com.app.gateway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private TextView _signupTXT;
    private EditText _nameET,_emailET,_mobileET,_dobET,_addressET,_pwdET; ;
    private Button _signupBTN;

    String name, email, mobile, dob, address, pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        _nameET=findViewById(R.id.nameET);
        _emailET=findViewById(R.id.emailET);
        _mobileET=findViewById(R.id.mobileET);
       /* _dobET=findViewById(R.id.dobET);*/
        _addressET=findViewById(R.id.addressET);
        _pwdET=findViewById(R.id.pwdET);
        _signupBTN=findViewById(R.id.signupBTN);
        _signupTXT=findViewById(R.id.signupTXT);


        _signupTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        _signupBTN.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) { validation();
         }
     });
    }
    public void validation() {
        boolean check = true;
        name = _nameET.getText().toString().trim();
        email = _emailET.getText().toString().trim();
        mobile = _mobileET.getText().toString().trim();
/*
        dob = _dobET.getText().toString().trim();
*/
        address = _addressET.getText().toString().trim();
        pwd = _pwdET.getText().toString().trim();


        if (name.isEmpty()) {
            _nameET.setError("Field can't be empty");
            check = false;

        }
        if (email.isEmpty()) {
            _emailET.setError("Field can't be empty");
            check = false;

        }
        if (mobile.isEmpty()) {
            _mobileET.setError("Field can't be empty");
            check = false;

    }
  /*      if (dob.isEmpty()) {
        _dobET.setError("Field can't be empty");
        check = false;

    }*/
            if (address.isEmpty()) {
                _addressET.setError("Field can't be empty");
                check = false;

            }
            if (pwd.isEmpty()) {
                _pwdET.setError("Field can't be empty");
                check = false;

            }


            if (check == true) {

                Toast.makeText(this, "Signup SuccessFully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);

            }


        }


    }
