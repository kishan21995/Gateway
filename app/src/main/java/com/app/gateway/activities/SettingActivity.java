package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.gateway.R;
import com.app.gateway.utils.Constants;
import com.app.gateway.utils.HFMPrefs;

public class SettingActivity extends AppCompatActivity {

    private ImageView _editIMG, _backIMG;
    private LinearLayout _linearLayoutEdit, _addFlatVillaLT,_linearlogout_signout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        _editIMG=findViewById(R.id.editIMG);
        _backIMG=findViewById(R.id.backIMG);

        _linearLayoutEdit=findViewById(R.id.editLT);


        _addFlatVillaLT=findViewById(R.id.addflatVillaLT);
        _linearlogout_signout=findViewById(R.id.linearlogout_signout);


        _linearlogout_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userlogout();
            }
        });



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

    private void userlogout() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        // ...Irrelevant code for customizing the buttons and titl
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.profile_alertdialog, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog dialog = dialogBuilder.create();
        Button btn_Cancel = dialogView.findViewById(R.id.btn_cancel);
        TextView text_logout = dialogView.findViewById(R.id.text_logout);
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
