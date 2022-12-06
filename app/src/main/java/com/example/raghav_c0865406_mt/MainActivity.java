package com.example.raghav_c0865406_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioButton;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Map<String, Integer> map = new HashMap<String, Integer>();
    //final TextView dailyRent = findViewById(R.id.dailyRentTextView);
    int tableNumber = 0;
    RadioGroup rdg;
    int age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);
        final SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView daysText = findViewById(R.id.daysTextView);
        rdg = findViewById(R.id.radioGroup);






        map.put("Swift", 100);
        map.put("RAM", 150);
        map.put("Mustang", 200);
        map.put("Charger", 250);
        map.put("Ferrari", 200);
        map.put("Volvo", 300);
        map.put("Volkswagon", 120);
        map.put("Honda", 130);
        map.put("Hyundai", 190);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, map.keySet().toArray());
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tableNumber = i;
                System.out.println("This is Table Number : " + tableNumber);
                String finalText = "How many days you want to rent      "+tableNumber+"days";
                daysText.setText(finalText);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        int price = map.get(map.keySet().toArray()[position]);
       // final TextView dailyR = findViewById(R.id.dailyRentTextView);
       // dailyRent.setText(String.valueOf(price));
        int i = rdg.getCheckedRadioButtonId();
        RadioButton r = (RadioButton) findViewById(i);
        String rvalue = r.getText().toString();
        System.out.println("This is Radio Output: "+ rvalue);

        switch (rvalue){
            case "Less Than 20":
                price = price+5;
                break;
            case "Above 60":
                price = price-10;
                break;
        }

        System.out.println("PRice is this: "+ price);





    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}