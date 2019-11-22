package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.gateway.R;

public class SettingActivity extends AppCompatActivity {

    private ImageView _editIMG, _backIMG;
    private LinearLayout _linearLayoutEdit, _addFlatVillaLT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        _editIMG=findViewById(R.id.editIMG);
        _backIMG=findViewById(R.id.backIMG);

        _linearLayoutEdit=findViewById(R.id.editLT);
        _addFlatVillaLT=findViewById(R.id.addflatVillaLT);


        _linearLayoutEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SettingActivity.this, EditProfileActivity.class);
                startActivity(intent);

            }
        });

        _addFlatVillaLT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SettingActivity.this, AddFlatVillaActivity.class);
                startActivity(intent);

            }
        });


        _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
