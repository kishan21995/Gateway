package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.gateway.R;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.utils.Constants;
import com.app.gateway.utils.HFCPrefs;
import com.app.gateway.utils.HFMPrefs;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import static com.app.gateway.utils.Constants.LOGIN_DATA;

public class SettingActivity extends AppCompatActivity {



    private ImageView _editIMG, _backIMG,_usernameIMG;
    private LinearLayout _linearLayoutEdit, _addFlatVillaLT,_linearlogout_signout;
    private RelativeLayout rela_share,feed;
    private TextView _usernameTV,_usernameEMAIL,_usernameMOBILE,_usernamePASSCODE;


    //Shared Preference
    LoginResponse loginResponse;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        _usernameTV=findViewById(R.id.usernameTV6);
        _usernameEMAIL=findViewById(R.id.usernameEMAIL6);
        _usernameMOBILE=findViewById(R.id.usernameMOBILE6);
        _usernamePASSCODE=findViewById(R.id.usernamePASSCODE6);



        _editIMG=findViewById(R.id.editIMG);
        _backIMG=findViewById(R.id.backIMG);

        _linearLayoutEdit=findViewById(R.id.editLT);
        rela_share=findViewById(R.id.rela_share);
        feed=findViewById(R.id.feedback);



        _addFlatVillaLT=findViewById(R.id.addflatVillaLT);
        _linearlogout_signout=findViewById(R.id.linearlogout_signout);

        //settingData();

       /* String data = HFMPrefs.getString(getApplicationContext(), Constants.LOGIN_DATA);
        loginResponse = new Gson().fromJson(data, LoginResponse.class);*/


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
        rela_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String text = " Gateway Application ,click below to download\nhttps://play.google.com/store/apps/details?id=com.app.ekomkarseriesfinalappdemo&hl=en";
                share.putExtra(Intent.EXTRA_SUBJECT, "Gatway");
                share.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(share, "share via"));

            }
        });

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userfeed();
            }
        });






       LoginResponse loginResponse = new Gson().fromJson(HFCPrefs.getString(this,LOGIN_DATA),LoginResponse.class);

        //Log.d("mdfnv", "onCreate: "+loginResponses);



        if (loginResponse.getUsername()!=null ){
            _usernameTV.setText(loginResponse.getUsername() );
        }else {
            _usernameTV.setText(" " );
        }

        if (loginResponse.getEmail()!=null ){
            _usernameEMAIL.setText(loginResponse.getEmail() );
        }else {
            _usernameEMAIL.setText(" " );
        }

        if (loginResponse.getMobile()!=null ){
            _usernameMOBILE.setText(loginResponse.getMobile() );
        }else {
            _usernameMOBILE.setText(" " );
        }

        if (loginResponse.getPasscode()!=null ){
            _usernamePASSCODE.setText(loginResponse.getPasscode() );
        }else {
            _usernamePASSCODE.setText(" " );
        }




    }

   /* @Override
    protected void onResume() {
        super.onResume();
        settingData();
    }

    private void settingData() {

        String data = HFMPrefs.getString(getApplicationContext(), Constants.LOGIN_DATA);
        loginResponse = new Gson().fromJson(data, LoginResponse.class);


        if (loginResponse.getUsername() != null) {
            _usernameTV.setText( loginResponse.getUsername() );
        }

        if (loginResponse.getEmail() != null) {
            _usernameEMAIL.setText( loginResponse.getEmail());
        }
        if (loginResponse.getMobile() != null) {
            _usernameMOBILE.setText( loginResponse.getMobile());
        }
        if (loginResponse.getPasscode() != null) {
            _usernamePASSCODE.setText( loginResponse.getPasscode());
        }

    }*/



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
                startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                finish();
            }
        });

        dialog.show();

    }

    private void userfeed() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        // ...Irrelevant code for customizing the buttons and titl
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.feedback, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog dialog = dialogBuilder.create();
      /*  Button btn_Cancel = dialogView.findViewById(R.id.btn_cancel);
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
*//*
                HFMPrefs.putBoolean(SettingActivity.this, Constants.LOGIN_CHECK, false);
*//*
                //startActivity(new Intent(SettingActivity.this, LoginActivity.class));
                finish();
            }
        });*/

        dialog.show();

    }

}
