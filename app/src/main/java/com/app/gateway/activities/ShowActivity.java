package com.app.gateway.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.gateway.models.image.ImageModel;
import com.app.gateway.R;
import com.app.gateway.adapters.SlidingImage_Adapter;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private LinearLayout prof_section;
    private Button Signout;
    private SignInButton Signin;
    private TextView Name,Email;
    private ImageView Pro_pic;
    private GoogleApiClient googleApiClient;
    private  static final int REQ_CODE=9001;


    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageModel> imageModelArrayList;

    private int[] myImageList = new int[]{
            R.drawable.splashbg,R.drawable.four
            ,R.drawable.three};


    private Button _logBTN;
    private TextView _signupTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        prof_section=(LinearLayout) findViewById(R.id.prof_section);
        Signout=(Button) findViewById(R.id.bn_logout);
        Signin=(SignInButton) findViewById(R.id.bn_login);
        Name=(TextView) findViewById(R.id.name);
        Email=(TextView)findViewById(R.id.email);
        Pro_pic=(ImageView) findViewById(R.id.pro_pic);
        Signin.setOnClickListener(this);
        Signout.setOnClickListener(this);
        prof_section.setVisibility(View.GONE);
        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions).build();


        _logBTN=findViewById(R.id.logBTN);
        _signupTXT=findViewById(R.id.signupTXT);


        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = populateList();

       init();


/*        _logBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShowActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });*/

_logBTN.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(ShowActivity.this, LoginActivity.class);
        startActivity(intent);
    }
});

        _signupTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ShowActivity.this, SignupActivity.class);
                startActivity(intent);

            }
        });

    }

    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }

    private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(ShowActivity.this,imageModelArrayList));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 4000, 4000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });




    }



        @Override
        public void onClick(View v) {

        switch (v.getId()){

            case R.id.bn_login:
                signIn();
                break;

            case R.id.bn_logout:
                signOut();
                break;


        }



    }

        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        }

        private void signIn(){

            Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
            startActivityForResult(intent,REQ_CODE);

        }

        private void signOut(){

            Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                @Override
                public void onResult(@NonNull Status status) {
                    updateUI(false);
                }
            });

        }

       private void handleResult(GoogleSignInResult result){

           if(result.isSuccess()){

               GoogleSignInAccount account=result.getSignInAccount();
               String name=account.getDisplayName();
               String email=account.getEmail();
               String img_url=account.getPhotoUrl().toString();
               Name.setText(name);
               Email.setText(email);
               Glide.with(this).load(img_url).into(Pro_pic);
               updateUI(true);

           }else {


               updateUI(false);
           }

       }

       private void updateUI(boolean isLogin){

           if(isLogin){
               prof_section.setVisibility(View.VISIBLE);
               Signin.setVisibility(View.GONE);
           }else {

               prof_section.setVisibility(View.GONE);
               Signin.setVisibility(View.VISIBLE);

           }

       }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_CODE){

            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }

    }
}
