package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.gateway.R;

public class ForgatePasswordActivity extends AppCompatActivity {

    private EditText _emailET;
    private Button _sendBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgate_password);

        _emailET=findViewById(R.id.emailET);
        _sendBTN=findViewById(R.id.sendBTN);


        _sendBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });

    }

    public void Validation() {
        boolean check = true;
        String email = _emailET.getText().toString().trim();

        if (email.isEmpty()) {
            _emailET.setError("Field can't be empty");
            check = false;
        }

        if (check == true) {

            Toast.makeText(this, "Login SuccessFully", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(ForgatePasswordActivity.this, SettingActivity.class);
            startActivity(intent);

        }
    }
}
