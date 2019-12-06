package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.gateway.R;

public class LocalServicesActivity extends AppCompatActivity {
    private ImageView _backIMG;
    private LinearLayout _maid,_driver,_cook,_milkMan,_paperBoy,_carCleaner,_electrician,_laundry,_staff,_gardener,_vegetable,_interiorWork,_scrapDealer,_allLLT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_services);

        initialView();
        clickListenerView();

    }

    public void initialView(){


        _backIMG=findViewById(R.id.backIMG);
        _maid=findViewById(R.id.maidLLT);
        _driver=findViewById(R.id.driverLLT);
        _cook=findViewById(R.id.cookLLT);
        _milkMan=findViewById(R.id.milkmanLLT);
        _paperBoy=findViewById(R.id.paperboyLLt);
        _carCleaner=findViewById(R.id.carCleanerLLT);
        _electrician=findViewById(R.id.electricianLLT);
        _laundry=findViewById(R.id.laundryLLT);
        _staff=findViewById(R.id.stafLLT);
        _gardener=findViewById(R.id.gardenerLLT);
        _vegetable=findViewById(R.id.vegetableLLT);
        _interiorWork=findViewById(R.id.interiorLLT);
        _scrapDealer=findViewById(R.id.scrapDealerLLT);
        _allLLT=findViewById(R.id.all_LLT);


    }

    public void  clickListenerView(){
        _backIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        _maid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,MaidActivity.class);
                startActivity(intent);
            }
        });

        _driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,DriverActivity.class);
                startActivity(intent);
            }
        });

        _cook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,CookActivity.class);
                startActivity(intent);
            }
        });

        _milkMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,MilkmanActivity.class);
                startActivity(intent);
            }
        });

        _paperBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,PaperboyActivity.class);
                startActivity(intent);
            }
        });

        _carCleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,CarCleanerActivity.class);
                startActivity(intent);
            }
        });

        _electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,ElectricianActivity.class);
                startActivity(intent);
            }
        });

        _laundry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,LaundryActivity.class);
                startActivity(intent);
            }
        });

        _staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,StaffActivity.class);
                startActivity(intent);
            }
        });

        _gardener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,GardenerActivity.class);
                startActivity(intent);
            }
        });

        _vegetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,VegetableActivity.class);
                startActivity(intent);
            }
        });

        _interiorWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,InteriorWorkActivity.class);
                startActivity(intent);
            }
        });

        _scrapDealer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalServicesActivity.this,ScrapDealerActivity.class);
                startActivity(intent);
            }
        });


    }


}
