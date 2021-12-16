package com.example.mainui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.mainui.Fragments.Games.NumberGussingGame;
import com.example.mainui.R;


public class GamesFragments extends Fragment {

    ImageView NGG;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_games_fragments, container, false);
        NGG = v.findViewById(R.id.guessnumber_img);
        NGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NumberGussingGame.class);
                startActivity(intent);
            }
        });
        return v;
    }
}