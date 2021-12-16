package com.example.mainui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.mainui.Fragments.Tools.UnitConverter;
import com.example.mainui.R;


public class ToolsFragments extends Fragment {

    ImageView UC;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tools_fragments, container, false);
        UC = v.findViewById(R.id.unitConvert_img);
        UC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UnitConverter.class);
                startActivity(intent);
            }
        });


        return v;
    }
}