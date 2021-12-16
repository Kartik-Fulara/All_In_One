package com.example.mainui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mainui.Fragments.GamesFragments;
import com.example.mainui.Fragments.SocialsFragments;
import com.example.mainui.Fragments.ToolsFragments;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

//    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            viewPager = findViewById(R.id.viewpager);
            tabLayout = findViewById(R.id.tab_layout);

            tabLayout.setupWithViewPager(viewPager);

            VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            vpAdapter.addFragment(new GamesFragments(),"Games");
            vpAdapter.addFragment(new ToolsFragments(),"Tools");
            vpAdapter.addFragment(new SocialsFragments(),"Socials");

            viewPager.setAdapter(vpAdapter);
    }



}