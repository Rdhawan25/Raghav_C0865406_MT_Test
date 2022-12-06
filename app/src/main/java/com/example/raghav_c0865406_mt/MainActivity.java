package com.example.raghav_c0865406_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.RadioButton;


import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Map<String, Integer> map = new HashMap<String, Integer>();
    TextView dailyRent;
    int tableNumber = 1;
    RadioGroup rdg;
    CheckBox gps;
    CheckBox childSeat;
    CheckBox ulMileage;
    TextView amount;
    TextView totalAmount;
    int price;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;





    public void actionPerformed(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);
        final SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView daysText = findViewById(R.id.daysTextView);
        rdg = findViewById(R.id.radioGroup);
        gps = findViewById(R.id.checkBoxGPS);
        childSeat = findViewById(R.id.checkBoxChildSeat);
        ulMileage = findViewById(R.id.checkBoxUnlimitedMileage);
        amount = findViewById(R.id.amoutTextView);
        totalAmount = findViewById(R.id.totalTextView);
        dailyRent = findViewById(R.id.dailyRentTextView);
        r1 = findViewById(R.id.radioButtonLT20);
        r2 = findViewById(R.id.radioButtonBTW2160);
        r3 = findViewById(R.id.radioButtonAbove60);


//gps.addOnAttachStateChangeListener(this);
gps.setOnClickListener(this);
        childSeat.setOnClickListener(this);
        ulMileage.setOnClickListener(this);
        rdg.setOnClickListener(this);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);





        map.put("Swift", 100);
        map.put("RAM", 150);
        map.put("Mustang", 200);
        map.put("Charger", 250);
        map.put("Ferrari", 200);
        map.put("Volvo", 300);
        map.put("Volkswagen", 120);
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
        price = map.get(map.keySet().toArray()[position]);


        System.out.println("PRice is this: "+ price);

        price = price*tableNumber;
        amount.setText(String.valueOf(price));
        float total = (float) (price+(price*0.13));
        totalAmount.setText(String.valueOf(total));







    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onClick(View view) {

        if (view == gps){
            price = price+5;
        }
        if (view == childSeat){
            System.out.println("THIS is ** Child");
            price = price+7;
        }
        if (view == ulMileage){
            System.out.println("THIS is ** Ml");
            price = price+10;
        }
        if(view == r1 || view == r3){
            int i = rdg.getCheckedRadioButtonId();
            RadioButton r = (RadioButton) findViewById(i);
            String rvalue = r.getText().toString();
            System.out.println("This is Radio Output: "+ rvalue);

            switch (rvalue){
                case "Less Than 20":
                    System.out.println("THIS is ** Radio 1");
                    price = price+5;

                    break;
                case "Above 60":
                    System.out.println("THIS is ** Radio 2");
                    price = price-10;
                    break;
            }

        }

        price = price*tableNumber;
        amount.setText(String.valueOf(price));
        float total = (float) (price+(price*0.13));
        totalAmount.setText(String.valueOf(total));

    }
}