package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.gateway.R;

public class ResidentsActivity extends AppCompatActivity  {
    private ImageView _backIMG;
    private LinearLayout maidA1,maidA2,maidA3,maidA4,maidB1,maidB2,maidB3,maidB4,maidC1,maidC2,maidC3,maidC4,maidC5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residents);

        init();
        onClickListner();



    }

public void init(){

    _backIMG=findViewById(R.id.backIMG);
    maidA1=findViewById(R.id.maidLLT2);
    maidA2=findViewById(R.id.maidLLT3);
    maidA3=findViewById(R.id.maidLLT4);
    maidA4=findViewById(R.id.maidLLT5);
    maidB1=findViewById(R.id.maidLLT6);
    maidB2=findViewById(R.id.maidLLT7);
    maidB3=findViewById(R.id.maidLLT8);
    maidB4=findViewById(R.id.maidLLT9);
    maidC1=findViewById(R.id.maidLLT10);
    maidC2=findViewById(R.id.maidLLT11);
    maidC3=findViewById(R.id.maidLLT12);
    maidC4=findViewById(R.id.maidLLT13);
    maidC5=findViewById(R.id.maidLLT14);


                  }


public void onClickListner(){



        _backIMG.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(ResidentsActivity.this,MainActivity.class);
            startActivity(intent);
        }
    });

        


        maidA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResidentsActivity.this, ResidentsA1.class);
                startActivity(intent);
            }

        });

    maidA2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsA2.class);
            startActivity(intent);
        }

    });

    maidA3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsA3.class);
            startActivity(intent);
        }

    });

    maidA4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsA4.class);
            startActivity(intent);
        }

    });

    maidB1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsB1.class);
            startActivity(intent);
        }

    });

    maidB2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsB2.class);
            startActivity(intent);
        }

    });

    maidB3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsB3.class);
            startActivity(intent);
        }

    });

    maidB4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsB4.class);
            startActivity(intent);
        }

    });

    maidC1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsC1.class);
            startActivity(intent);
        }

    });

    maidC2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsC2.class);
            startActivity(intent);
        }

    });

    maidC3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsC3.class);
            startActivity(intent);
        }

    });

    maidC4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsC4.class);
            startActivity(intent);
        }

    });

    maidC5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ResidentsActivity.this, ResidentsC5.class);
            startActivity(intent);
        }

    });

    }}
