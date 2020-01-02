package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.gateway.R;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.utils.HFCPrefs;
import com.google.gson.Gson;

import static com.app.gateway.utils.Constants.LOGIN_DATA;

public class EditProfileActivity extends AppCompatActivity {
    private ImageView _backIMG;
    private EditText _nameET, _phoneET, _emailET;
    private Button _saveBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        _backIMG=findViewById(R.id.backIMG);
        _nameET=findViewById(R.id.usernameET);
        _phoneET=findViewById(R.id.phoneET);
        _emailET=findViewById(R.id.emailET);
        _saveBTN=findViewById(R.id.saveBTN);

        _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        _saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Validation();
            }
        });


        LoginResponse loginResponse = new Gson().fromJson(HFCPrefs.getString(this,LOGIN_DATA),LoginResponse.class);

        //Log.d("mdfnv", "onCreate: "+loginResponses);



        if (loginResponse.getUsername()!=null ){
            _nameET.setText(loginResponse.getUsername() );
        }else {
            _nameET.setText(" " );
        }

        if (loginResponse.getEmail()!=null ){
            _emailET.setText(loginResponse.getEmail() );
        }else {
            _emailET.setText(" " );
        }

        if (loginResponse.getMobile()!=null ){
            _phoneET.setText(loginResponse.getMobile() );
        }else {
            _phoneET.setText(" " );
        }

      /*  if (loginResponse.getPasscode()!=null ){
            _usernamePASSCODE.setText(loginResponse.getPasscode() );
        }else {
            _usernamePASSCODE.setText(" " );
        }*/

    }
    public void Validation() {
        boolean check = true;
        String name = _nameET.getText().toString().trim();
        String phone = _phoneET.getText().toString().trim();
        String email = _emailET.getText().toString().trim();

        if (name.isEmpty()) {
            _nameET.setError("Field can't be empty");
            check = false;
        }

        if (phone.isEmpty()) {
            _phoneET.setError("Field can't be empty");
            check = false;
        }

        if (email.isEmpty()) {
            _emailET.setError("Field can't be empty");
            check = false;
        }


        if (check == true) {
            Toast.makeText(this, "Profile Update Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(EditProfileActivity.this, SettingActivity.class);
            startActivity(intent);
        }
    }
}
