package com.example.mainui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mainui.Fragments.Social.AppStatus;
import com.example.mainui.Fragments.Social.WebActivity;
import com.example.mainui.R;


public class SocialsFragments extends Fragment {

    ImageView Amazon_btn;
    ImageView Flipkart_btn;
    ImageView Facebook_btn;
    ImageView Instagram_btn;
    ImageView LinkedIN_btn;
    ImageView Twitter_btn;

    String[] urls = new String[6];


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_socials_fragments, container, false);

        Amazon_btn = view.findViewById(R.id.Amazon_img);
        Flipkart_btn = view.findViewById(R.id.Flipkart_img);
        Facebook_btn = view.findViewById(R.id.Facebook_img);
        Instagram_btn = view.findViewById(R.id.Insta_img);
        LinkedIN_btn = view.findViewById(R.id.link_img);
        Twitter_btn = view.findViewById(R.id.tweet_img);

        urls[0] = "https://www.amazon.in/";
        urls[1] = "https://www.facebook.com/";
        urls[2] = "https://www.flipkart.com/";
        urls[3] = "https://www.instagram.com/";
        urls[4] = "https://www.linkedin.com/";
        urls[5] = "https://twitter.com/";

        Amazon_btn.setOnClickListener(view1 -> {
            if (AppStatus.getInstance(requireContext()).isOnline()) {
                WebsiteCall("Amazon",0);
            } else {

                Toast.makeText(getContext(),"No Internet Connection!!!!",Toast.LENGTH_LONG).show();
                Log.v("Home", "############################You are not online!!!!");
            }

        });
        Facebook_btn.setOnClickListener(view12 -> {
            if (AppStatus.getInstance(requireContext()).isOnline()) {
                WebsiteCall("Facebook",1);
            } else {

                Toast.makeText(getContext(),"No Internet Connection!!!!",Toast.LENGTH_LONG).show();
                Log.v("Home", "############################You are not online!!!!");
            }

        });
        Flipkart_btn.setOnClickListener(view13 -> {
            if (AppStatus.getInstance(requireContext()).isOnline()) {
                WebsiteCall("Flipkart",2);
            } else {

                Toast.makeText(getContext(),"No Internet Connection!!!!",Toast.LENGTH_LONG).show();
                Log.v("Home", "############################You are not online!!!!");
            }
        });
        Instagram_btn.setOnClickListener(view14 -> {
            if (AppStatus.getInstance(requireContext()).isOnline()) {
                WebsiteCall("Instagram",3);
            } else {

                Toast.makeText(getContext(),"No Internet Connection!!!!",Toast.LENGTH_LONG).show();
                Log.v("Home", "############################You are not online!!!!");
            }
        });
        LinkedIN_btn.setOnClickListener(view15 -> {
            if (AppStatus.getInstance(requireContext()).isOnline()) {
                WebsiteCall("LinkedIn",4);
            } else {

                Toast.makeText(getContext(),"No Internet Connection!!!!",Toast.LENGTH_LONG).show();
                Log.v("Home", "############################You are not online!!!!");
            }

        });
        Twitter_btn.setOnClickListener(view16 -> {
            if (AppStatus.getInstance(requireContext()).isOnline()) {
                WebsiteCall("Twitter",5);
            } else {

                Toast.makeText(getContext(),"No Internet Connection!!!!",Toast.LENGTH_LONG).show();
                Log.v("Home", "############################You are not online!!!!");
            }

        });



        return view;
    }

    public void WebsiteCall(String Name,int No){

        Toast.makeText(getContext(), Name, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("links",urls[No]);
        startActivity(intent);

    }
}