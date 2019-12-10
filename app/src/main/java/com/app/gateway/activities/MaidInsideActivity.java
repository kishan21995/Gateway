package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.gateway.R;

public class MaidInsideActivity extends AppCompatActivity {
    private LinearLayout profile1,profile2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid_inside);

        profile1=findViewById(R.id.pro1LLT);
        profile2=findViewById(R.id.profile2LLT);

        profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MaidInsideActivity.this,MaidProfile1Activity.class);
                startActivity(intent);

            }
        });

        profile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MaidInsideActivity.this,MaidProfile2Activity.class);
                startActivity(intent);

            }
        });

    }
}
