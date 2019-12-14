package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.gateway.R;

public class ResidentsB4 extends AppCompatActivity {
    private ImageView _backIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residents_b4);

        _backIMG=findViewById(R.id.backIMG);

        _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ResidentsB4.this,ResidentsActivity.class);
                startActivity(intent);

            }
        });

    }
}
