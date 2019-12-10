package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.app.gateway.R;

public class ScrapDealerActivity extends AppCompatActivity {

    private ImageView _backIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrap_dealer);

        _backIMG=findViewById(R.id.backIMG);

        _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScrapDealerActivity.this,LocalServicesActivity.class);
                startActivity(intent);
            }
        });

    }
}
