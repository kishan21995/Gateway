package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.app.gateway.R;

public class MaidProfile1Activity extends AppCompatActivity {
    private ImageView _backIMG;
    private Button _showAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid_profile1);

        _backIMG=findViewById(R.id.backIMG);
        _showAll=findViewById(R.id.showAll);


        _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MaidProfile1Activity.this,MaidActivity.class);
                startActivity(intent);
            }
        });

        _showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MaidProfile1Activity.this,ReviewActivity.class);
                startActivity(intent);
            }
        });

    }
}
