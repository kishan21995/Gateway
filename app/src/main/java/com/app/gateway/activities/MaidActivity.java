package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.gateway.R;

public class MaidActivity extends AppCompatActivity {
    private LinearLayout pro1,pro2;
    private ImageView _backIMG;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid);


        _backIMG=findViewById(R.id.backIMG);
        checkBox=findViewById(R.id.checkbox);
        pro1=findViewById(R.id.profile1LLT);
        pro2=findViewById(R.id.profile2LLT);

        pro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MaidActivity.this,MaidProfile1Activity.class);
                startActivity(intent);
            }
        });  _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MaidActivity.this,LocalServicesActivity.class);
                startActivity(intent);
            }
        });

        pro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MaidActivity.this,MaidProfile2Activity.class);
                startActivity(intent);
            }
        });



        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               /* Intent intent = new Intent(getActivity(), AutoBillingActivity.class);
                startActivity(intent);*/

               Intent intent=new Intent(MaidActivity.this,MaidInsideActivity.class);
               startActivity(intent);

            }
        });

    }
}
