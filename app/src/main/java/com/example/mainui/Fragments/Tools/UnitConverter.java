package com.example.mainui.Fragments.Tools;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mainui.Fragments.Tools.Units.AreaConvert;
import com.example.mainui.Fragments.Tools.Units.CurrencyConvert;
import com.example.mainui.Fragments.Tools.Units.EnergyConvert;
import com.example.mainui.Fragments.Tools.Units.LengthConvert;
import com.example.mainui.Fragments.Tools.Units.PowerConvert;
import com.example.mainui.Fragments.Tools.Units.TemperatureConvert;
import com.example.mainui.Fragments.Tools.Units.VelocityConvert;
import com.example.mainui.Fragments.Tools.Units.VolumeConvert;
import com.example.mainui.Fragments.Tools.Units.WeightConvert;
import com.example.mainui.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class UnitConverter extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);


        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        adapter = new MainAdapter(getSupportFragmentManager());

        adapter.AddFragment(new AreaConvert(),"AREA");
        adapter.AddFragment(new CurrencyConvert(),"CURRENCY");
        adapter.AddFragment(new EnergyConvert(),"ENERGY");
        adapter.AddFragment(new LengthConvert(),"LENGTH");
        adapter.AddFragment(new PowerConvert(),"POWER");
        adapter.AddFragment(new TemperatureConvert(),"TEMPERATURE");
        adapter.AddFragment(new VelocityConvert(),"VELOCITY");
        adapter.AddFragment(new VolumeConvert(),"VOLUME");
        adapter.AddFragment(new WeightConvert(),"WEIGHT");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }

    private  class MainAdapter extends FragmentPagerAdapter{

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        public void AddFragment(Fragment fragment,String s){
            fragmentArrayList.add(fragment);

            stringArrayList.add(s);

        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public MainAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size()
;        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringArrayList.get(position);
        }
    }
}