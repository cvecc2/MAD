package com.example.carpickerandroidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView vehicleSelection;
    private SeekBar budgetSlider;
    private SeekBar mpgSlider;
    private Button reccomendationButton;
    private RadioGroup radioGroup;
    private TextView seekBudgetValue;
    private TextView seekMPGValue;
    private RadioButton carRadioButton;
    private RadioButton suvRadioButton;
    private RadioButton sportsRadioButton;
    private ImageView imageView;

    private int mpgChoice = 0;
    private int vehicleChoice;
    private double budgetChoice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(savedInstanceState == null){
            seekBudgetValue.setText(String.valueOf("$0"));
        } else {
            seekBudgetValue.setText(String.valueOf("$" + progress));
        }*/
        //onSavedInstanceState(Bundle bundle)
        //save data into bundle
        //in onCreate after setContentView
        // if theres a bundle, read it out, update UI
        //halloween state
        //I really could not figure out how to do this, I checked all the Halloween labs but couldn't
        //find "halloween state" or anything that looked like what we needed to use. Online resources weren't much help either

        vehicleSelection = findViewById(R.id.vehicleSelection);
        budgetSlider = findViewById(R.id.budgetSlider);
        seekBudgetValue = findViewById(R.id.seekBudgetValue);
        mpgSlider = findViewById(R.id.mpgSlider);
        seekMPGValue = findViewById(R.id.seekMPGValue);
        reccomendationButton = findViewById(R.id.reccomendationButton);
        radioGroup = findViewById(R.id.radioGroup);
        carRadioButton = findViewById(R.id.carRadioButton);
        suvRadioButton = findViewById(R.id.suvRadioButton);
        sportsRadioButton = findViewById(R.id.sportsRadioButton);
        imageView = findViewById(R.id.imageView);

        budgetSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                seekBudgetValue.setText(String.valueOf("$" + progress));
                budgetChoice = progress;
                //return budgetChoice;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        mpgSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                seekMPGValue.setText(String.valueOf(progress + " MPG"));
                mpgChoice = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
//source: https://stackoverflow.com/questions/8956218/android-seekbar-setonseekbarchangelistener
        //return budgetChoice;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                int carID = radioGroup.getCheckedRadioButtonId();
                if (carID == R.id.carRadioButton) {
                    vehicleChoice = 0;
                } else if (carID == R.id.suvRadioButton) {
                    vehicleChoice = 1;
                } else if (carID == R.id.sportsRadioButton){
                    vehicleChoice = 2;
                }
            }
        });

    }

    //seekbar value display for budget
    public double findBudget(View view) {
        budgetSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                seekBudgetValue.setText(String.valueOf("$" + progress));
                budgetChoice = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        return budgetChoice;
    }

    //seekbar value display for mpg
    public int findMPG(View view) {
        mpgSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                seekMPGValue.setText(String.valueOf(progress + " MPG"));
                mpgChoice = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
//source: https://stackoverflow.com/questions/8956218/android-seekbar-setonseekbarchangelistener
        return mpgChoice;
    }

    public void pressGO(View view) {
        //findVehicle(view);
        int vehicle = vehicleChoice;
        int MPG = findMPG(view);
        double budget = findBudget(view);


        if (vehicle == 0) { //cars
            //switch (view.getId()) {
            //case R.id.carRadioButton:
            Log.i("test", "Cars selected");
            if ((budget >= 20000 && budget <= 30000) && (MPG > 25 && MPG < 40)) {
                vehicleSelection.setText(String.valueOf("Audi A3"));
                imageView.setImageResource(R.drawable.a3);
            } else if ((budget >= 30001 && budget <= 45000) && (MPG >= 27 && MPG <= 35)) {
                vehicleSelection.setText(String.valueOf("Audi A4"));
                imageView.setImageResource(R.drawable.a4);
            } else if ((budget >= 45001 && budget <= 50000) && (MPG >= 25 && MPG <= 33)) {
                vehicleSelection.setText(String.valueOf("Audi allroad"));
                imageView.setImageResource(R.drawable.allroad);
            } else if ((budget >= 50001 && budget <= 72000) && (MPG >= 20 && MPG <= 30)) {
                vehicleSelection.setText(String.valueOf("Audi A7"));
                imageView.setImageResource(R.drawable.a7);
            } else if ((budget >= 72001 && budget <= 100000) && (MPG >= 20 && MPG <= 30)) {
                vehicleSelection.setText(String.valueOf("Audi A8"));
                imageView.setImageResource(R.drawable.a8);
            } else {
                imageView.setImageResource(R.drawable.logo);
                Context context = getApplicationContext();
                CharSequence text = "Please Adjust Your Selection";
                vehicleSelection.setText(String.valueOf("No Vehicles Available"));
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        } else if (vehicle == 1) { //SUVs
            Log.i("test", "SUVs selected");
            if ((budget >= 45000 && budget <= 65000) && (MPG >= 24 && MPG <= 30)) {
                vehicleSelection.setText(String.valueOf("Audi Q7"));
                imageView.setImageResource(R.drawable.q7);
            } else if ((budget >= 65001 && budget <= 90000) && (MPG >= 22 && MPG <= 30)) {
                vehicleSelection.setText(String.valueOf("Audi Q8"));
                imageView.setImageResource(R.drawable.q8);
            } else {
                imageView.setImageResource(R.drawable.logo);
                Context context = getApplicationContext();
                CharSequence text = "Please Adjust Your Selection";
                vehicleSelection.setText(String.valueOf("No Vehicles Available"));
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        } else if (vehicle == 2) { //sports cars
            Log.i("test", "Sports Cars selected");
            if ((budget >= 45000 && budget <= 55000) && (MPG >= 27 && MPG <= 35)) {
                vehicleSelection.setText(String.valueOf("Audi S4"));
                imageView.setImageResource(R.drawable.s4);
            } else if ((budget >= 55001 && budget <= 60000) && (MPG >= 27 && MPG <= 35)) {
                vehicleSelection.setText(String.valueOf("Audi S5"));
                imageView.setImageResource(R.drawable.s5);
            } else if ((budget >= 60001 && budget <= 72000) && (MPG >= 25 && MPG <= 33)) {
                vehicleSelection.setText(String.valueOf("Audi SQ5"));
                imageView.setImageResource(R.drawable.sq5);
            } else if ((budget >= 90000 && budget <= 100000) && (MPG >= 15 && MPG <= 25)) {
                vehicleSelection.setText(String.valueOf("Audi R8"));
                imageView.setImageResource(R.drawable.r8);
            } else {
                imageView.setImageResource(R.drawable.logo);
                Context context = getApplicationContext();
                CharSequence text = "Please Adjust Your Selection";
                vehicleSelection.setText(String.valueOf("No Vehicles Available"));
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }


        }
    }
}

