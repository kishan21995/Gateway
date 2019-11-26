package com.app.gateway.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.app.gateway.fragments.CommunityFragment;
import com.app.gateway.R;
import com.app.gateway.fragments.ActivityFragment;
import com.app.gateway.fragments.HouseholdFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private Spinner spinner;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView _settingIMG , _helpIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        _settingIMG=findViewById(R.id.settingIMG);
        _helpIMG=findViewById(R.id.helpIMG);
        spinner=findViewById(R.id.spinner);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        List<String>list=new ArrayList<String>();
        list.add("Add Flat/Villa");
        list.add("Tower 1001");
        list.add("Tower 1002");
        list.add("Tower 1003");
        list.add("Tower 1004");
        list.add("Tower 1005");
        list.add("Add Flat/Villa");





        _settingIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        _helpIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });



        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        //jo hum item select kre vo spinner pe dikh jaye//
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            //ek jo show krana h//
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i);

            }

            @Override
            //ek jo show nhi h//
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CommunityFragment(), "Community");
        adapter.addFragment(new HouseholdFragment(), "Household");
        adapter.addFragment(new ActivityFragment(), "Activity");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment , String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}


