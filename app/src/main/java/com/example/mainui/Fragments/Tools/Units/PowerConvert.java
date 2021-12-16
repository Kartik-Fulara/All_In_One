package com.example.mainui.Fragments.Tools.Units;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mainui.R;


public class PowerConvert extends Fragment implements AdapterView.OnItemSelectedListener{


    Spinner from;
    Spinner to;
    Button convert;
    EditText value;
    TextView answer;
    String FROM;
    String TO;
    Double Value;
    String val;
    Double ret;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_area_convert,container,false);
        from = (Spinner) v.findViewById(R.id.FROMUNIT);
        to = (Spinner) v.findViewById(R.id.TOUNIT);
        value = (EditText) v.findViewById(R.id.Input);
        answer = (TextView) v.findViewById(R.id.answer);

        convert = (Button) v.findViewById(R.id.convert);





        //Creating an Array to populate the spinner with the data in the string resources
        ArrayAdapter<CharSequence> spinnerfromAdapter = ArrayAdapter.createFromResource(getContext(),R.array.powerunit, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> spinnertoAdapter = ArrayAdapter.createFromResource(getContext(),R.array.powerunit, android.R.layout.simple_spinner_item);

        spinnerfromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        from.setAdapter(spinnerfromAdapter);
        from.setOnItemSelectedListener(this);
        to.setAdapter(spinnertoAdapter);
        to.setOnItemSelectedListener(this);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    val = value.getText().toString();
                    Value = Double.parseDouble(val);
                    Double ans = Convert(FROM,TO,Value);
                    String ANS = ans.toString();
                    answer.setText(ANS);
//                Toast.makeText(getContext(), ANS, Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    System.out.println(e);
                }


            }
        });
        return v;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getContext(), view.getId(), Toast.LENGTH_SHORT).show();
        switch(adapterView.getId()){
            case R.id.FROMUNIT:
                FROM = text;
                break;
            case R.id.TOUNIT:
                TO = text;
                break;
            default:
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public Double Convert(String from, String to, Double input){
        String arrayName = "powerunit";
        int arrayName_ID= getResources().getIdentifier(arrayName , "array",getContext().getPackageName());
// You had used "arrayName"
        String[] FROMTO = getResources().getStringArray(arrayName_ID);

//        Toast.makeText(getContext(), from +" "+ to, Toast.LENGTH_SHORT).show();
        if ((from.equals(FROMTO[1]) && to.equals(FROMTO[0]))) {
            // if((from.equals("square miles")) && (to.equals("square km"))){
            ret = 0.00134*input;

        }
        if ((from.equals(FROMTO[0]) && to.equals(FROMTO[1]))) {
            // if((from.equals("square km")) && (to.equals("square miles"))){
            ret = 745.7*input;

        }

        if ((from.equals(FROMTO[1]) && to.equals(FROMTO[2]))) {
            // if((from.equals("square miles")) && (to.equals("square m"))){
            ret = input/1000;

        }
        if ((from.equals(FROMTO[2]) && to.equals(FROMTO[1]))) {
            // if((from.equals("square m")) && (to.equals("square miles"))){
            ret = input*1000;

        }

        if ((from.equals(FROMTO[0]) && to.equals(FROMTO[2]))) {
            // if((from.equals("square miles")) && (to.equals("square cm"))){
            ret = input*0.7457;

        }

        if ((from.equals(FROMTO[2]) && to.equals(FROMTO[0]))) {
            // if((from.equals("square cm")) && (to.equals("square miles"))){
            ret = input*1.34102;

        }



        if (from.equals(to)) {
            ret = input;
        }

        return ret;
    }
}