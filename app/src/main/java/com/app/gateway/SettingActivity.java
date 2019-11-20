package com.app.gateway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SettingActivity extends AppCompatActivity {

    private ImageView _editIMG, _backIMG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        _editIMG=findViewById(R.id.editIMG);
        _backIMG=findViewById(R.id.backIMG);


        _editIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SettingActivity.this,EditProfileActivity.class);
                startActivity(intent);

            }
        });


        _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SettingActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
