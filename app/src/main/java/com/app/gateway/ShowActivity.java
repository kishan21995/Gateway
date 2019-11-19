package com.app.gateway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowActivity extends AppCompatActivity {

    private Button _logBTN;
    private TextView _signupTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        _logBTN=findViewById(R.id.logBTN);
        _signupTXT=findViewById(R.id.signupTXT);

        _logBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ShowActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        _signupTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ShowActivity.this,SignupActivity.class);
                startActivity(intent);

            }
        });

    }
}
