package com.example.mainui.Fragments.Games;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mainui.R;

public class NumberGussingGame extends AppCompatActivity {

    int result;
    Button Guess;
    static int getRandomNumber(int max, int min)
    {
        return (int)((Math.random()
                * (max - min)) + min);
    }

    public void makeToast(String str)
    {
        Toast.makeText(NumberGussingGame.this, str, Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_gussing_game);

        int min = 1;
        int max = 100;
        result = getRandomNumber(min, max);
        Guess = findViewById(R.id.Guess);
        Guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    int userGuessing;
                    EditText variable
                            = (EditText)findViewById(R.id.editId);
                    userGuessing
                            = Integer.parseInt(variable.getText().toString());
                    if(userGuessing>100){
                        makeToast("Enter Number below 100 and greater than 1");
                    }
                    else if (userGuessing < result) {

                        makeToast("Think of Higher Number, Try Again");
                    } else if (userGuessing > result) {
                        makeToast("Think of Lower Number, Try Again");
                    } else {
                        makeToast("Congratulations," + " You Got the Number");
                    }
                }catch (Exception e) {
                    makeToast("Enter Number Only");
                }

            }
        });


    }
}
