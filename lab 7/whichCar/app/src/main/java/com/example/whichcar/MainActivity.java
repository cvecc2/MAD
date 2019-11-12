package com.example.whichcar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView vehicleSelection;
    private ToggleButton toggle;
    private Spinner bodystyle;
    private RadioGroup price;
    private CheckBox AWDCheckBox;
    private CheckBox heatedSeatsCheckBox;
    private CheckBox hybridElecCheckBox;
    private CheckBox convertibleCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicleSelection = findViewById(R.id.vehicleTextView);
        toggle = findViewById(R.id.toggleButton);
        bodystyle = findViewById(R.id.spinner);
        price = findViewById(R.id.radioGroup);
        AWDCheckBox = findViewById(R.id.checkBox1);
        heatedSeatsCheckBox = findViewById(R.id.checkBox2);
        hybridElecCheckBox = findViewById(R.id.checkBox3);
        convertibleCheckBox = findViewById(R.id.checkBox4);
    }
    public void findVehicle(View view){
        boolean location = toggle.isChecked();
        String vehicleType = String.valueOf(bodystyle.getSelectedItem());
        int price_id = price.getCheckedRadioButtonId();
        Boolean AWD = AWDCheckBox.isChecked();
        Boolean heatedseats = heatedSeatsCheckBox.isChecked();
        Boolean hybridelec = hybridElecCheckBox.isChecked();
        Boolean convertible = convertibleCheckBox.isChecked();

        String perfectCar = null;

        if(price_id == -1) {
            Context context = getApplicationContext();
            CharSequence text = "Please select a price range";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (location) { //american
                if (price_id == R.id.radioButton1) {
                    perfectCar = "Ford Fiesta ST";
                    if (AWD) {
                        perfectCar = "Cadillac ATS";
                    } else if (hybridelec){
                        perfectCar = "Chevrolet Vot";
                    } else if (convertible) {
                        perfectCar = "Ford Mustang Convertible";
                    } else if (heatedseats){
                        perfectCar = "Cadillac ATS";
                    }
                } else {
                    switch (vehicleType) {
                        case "sports car":
                            perfectCar = "Ford Mustang";
                            break;
                        case "passenger car":
                            perfectCar = "Chevrolet Impala";
                            break;
                        case "suvs":
                            perfectCar = "Chevrolet Equinox";
                            break;
                        default:
                            perfectCar = "Ford Fiesta ST";
                    }
                }
            } else { //japanese
                if (price_id == R.id.radioButton3) {
                    perfectCar = "Mazda 6";
                    if (AWD) {
                        perfectCar = "Lexus RX350";
                    } else if (hybridelec){
                        perfectCar = "Lexus RX350h";
                    } else if (convertible) {
                        perfectCar = "Mazda MX-5";
                    } else if (heatedseats){
                        perfectCar = "Subaru WRX";
                    }
                } else {
                    switch (vehicleType) {
                        case "sports car":
                            perfectCar = "Toyota Supra";
                            break;
                        case "passenger car":
                            perfectCar = "Honda Accord";
                            break;
                        case "suvs":
                            perfectCar = "Lexus RX350";
                            break;
                        default:
                            perfectCar = "Mazda 3";
                    }
                }
            }

            //text view
            vehicleSelection.setText("The " + perfectCar + " is the car for you");
        }
    }
}