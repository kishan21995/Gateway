package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.gateway.R;

public class MaidProfile1Activity extends AppCompatActivity {
    private ImageView _backIMG,starIMG;
    private Button _showAll,_addBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid_profile1);

        _backIMG=findViewById(R.id.backIMG);
        _showAll=findViewById(R.id.showAll);
        starIMG=findViewById(R.id.starIMG);
        _addBTN=findViewById(R.id.add_BTN);



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

        starIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:06396746908"));
                startActivity(intent);
            }
        });

        _addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addHousehoid();
                //add houses
            }
        });
    }


    private void addHousehoid() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        // ...Irrelevant code for customizing the buttons and titl
        LayoutInflater inflater = this.getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.add_household, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog dialog = dialogBuilder.create();
        Button btn_Cancel = dialogView.findViewById(R.id.btn_cancel);
        TextView text_logout = dialogView.findViewById(R.id.txt_Add);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

        text_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                HFMPrefs.putBoolean(SettingActivity.this, Constants.LOGIN_CHECK, false);
*/
                //startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                finish();
            }
        });

        dialog.show();

    }

}
