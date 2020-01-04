package com.app.gateway.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.gateway.R;
import com.app.gateway.models.login.LoginResponse;
import com.app.gateway.utils.HFCPrefs;
import com.google.gson.Gson;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.app.gateway.utils.Constants.LOGIN_DATA;


public class  EditProfileActivityOne extends AppCompatActivity {

    private ImageView _backIMG;
    private EditText _nameET, _phoneET, _emailET;
    private Button _saveBTN;

            private static final String TAG = MainActivity.class.getSimpleName();
            public static final int REQUEST_IMAGE = 100;

            @BindView(R.id.img_profile)
            ImageView imgProfile;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_edit_profile_one);

                _backIMG=findViewById(R.id.backIMG);
                _nameET=findViewById(R.id.usernameET);
                _phoneET=findViewById(R.id.phoneET);
                _emailET=findViewById(R.id.emailET);
                _saveBTN=findViewById(R.id.saveBTN);


                ButterKnife.bind(this);
                //Toolbar toolbar = findViewById(R.id.toolbar);
                //setSupportActionBar(toolbar);
                //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                //getSupportActionBar().setTitle(null);

                loadProfileDefault();

                // Clearing older images from cache directory
                // don't call this line if you want to choose multiple images in the same activity
                // call this once the bitmap(s) usage is over
                ImagePickerActivity.clearCache(this);


                _backIMG.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(EditProfileActivityOne.this, MainActivity.class);
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
            Intent intent = new Intent(EditProfileActivityOne.this, SettingActivity.class);
            startActivity(intent);
        }
    }

            private void loadProfile(String url) {
                Log.d(TAG, "Image cache path: " + url);

                GlideApp.with(this).load(url)
                        .into(imgProfile);
                imgProfile.setColorFilter(ContextCompat.getColor(this, android.R.color.transparent));
            }

            private void loadProfileDefault() {
                GlideApp.with(this).load(R.drawable.header_profileblack)

                        .into(imgProfile);                                  // change img color
                imgProfile.setColorFilter(ContextCompat.getColor(this, R.color.black));
            }

            @OnClick({R.id.img_plus, R.id.img_profile})
            void onProfileImageClick() {
                Dexter.withActivity(this)
                        .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new MultiplePermissionsListener() {
                            @Override
                            public void onPermissionsChecked(MultiplePermissionsReport report) {
                                if (report.areAllPermissionsGranted()) {
                                    showImagePickerOptions();
                                }

                                if (report.isAnyPermissionPermanentlyDenied()) {
                                    showSettingsDialog();
                                }
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }

            private void showImagePickerOptions() {
                ImagePickerActivity.showImagePickerOptions(this, new ImagePickerActivity.PickerOptionListener() {
                    @Override
                    public void onTakeCameraSelected() {
                        launchCameraIntent();
                    }

                    @Override
                    public void onChooseGallerySelected() {
                        launchGalleryIntent();
                    }
                });
            }

            private void launchCameraIntent() {
                Intent intent = new Intent( EditProfileActivityOne.this, ImagePickerActivity.class);
                intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_IMAGE_CAPTURE);

                // setting aspect ratio
                intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
                intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
                intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);

                // setting maximum bitmap width and height
                intent.putExtra(ImagePickerActivity.INTENT_SET_BITMAP_MAX_WIDTH_HEIGHT, true);
                intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_WIDTH, 1000);
                intent.putExtra(ImagePickerActivity.INTENT_BITMAP_MAX_HEIGHT, 1000);

                startActivityForResult(intent, REQUEST_IMAGE);
            }

            private void launchGalleryIntent() {
                Intent intent = new Intent( EditProfileActivityOne.this, ImagePickerActivity.class);
                intent.putExtra(ImagePickerActivity.INTENT_IMAGE_PICKER_OPTION, ImagePickerActivity.REQUEST_GALLERY_IMAGE);

                // setting aspect ratio
                intent.putExtra(ImagePickerActivity.INTENT_LOCK_ASPECT_RATIO, true);
                intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_X, 1); // 16x9, 1x1, 3:4, 3:2
                intent.putExtra(ImagePickerActivity.INTENT_ASPECT_RATIO_Y, 1);
                startActivityForResult(intent, REQUEST_IMAGE);
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == REQUEST_IMAGE) {
                    if (resultCode == Activity.RESULT_OK) {
                        Uri uri = data.getParcelableExtra("path");
                        try {
                            // You can update this bitmap to your server
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                            // loading profile image from local cache
                            loadProfile(uri.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            /**
             * Showing Alert Dialog with Settings option
             * Navigates user to app settings
             * NOTE: Keep proper title and message depending on your app
             */
            private void showSettingsDialog() {
                AlertDialog.Builder builder = new AlertDialog.Builder( EditProfileActivityOne.this);
                builder.setTitle(getString(R.string.dialog_permission_title));
                builder.setMessage(getString(R.string.dialog_permission_message));
                builder.setPositiveButton(getString(R.string.go_to_settings), (dialog, which) -> {
                    dialog.cancel();
                    openSettings();
                });
                builder.setNegativeButton(getString(android.R.string.cancel), (dialog, which) -> dialog.cancel());
                builder.show();

            }

            // navigating user to app settings
            private void openSettings() {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivityForResult(intent, 101);
            }
        }







