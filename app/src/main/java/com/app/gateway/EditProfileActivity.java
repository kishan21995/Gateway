package com.app.gateway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {
    private ImageView _backIMG;
    private EditText _nameET, _phoneET, _emailET;
    private Button _saveBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        _backIMG=findViewById(R.id.backIMG);
        _nameET=findViewById(R.id.nameET);
        _phoneET=findViewById(R.id.phoneET);
        _emailET=findViewById(R.id.emailET);
        _saveBTN=findViewById(R.id.saveBTN);





        _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(EditProfileActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        _saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              Validation();

            }
        });



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

            Intent intent = new Intent(EditProfileActivity.this, EditProfileActivity.class);
            startActivity(intent);

        }


    }

}
