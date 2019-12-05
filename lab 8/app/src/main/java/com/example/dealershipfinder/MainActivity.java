package com.example.dealershipfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner makeSpinner;
    private Dealership myDealer = new Dealership();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeSpinner=findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findDealer(v);
            }
        };
        button.setOnClickListener(onclick);
    }

    private void findDealer(View view){
        Integer make = makeSpinner.getSelectedItemPosition();
        myDealer.setDealershipName(make);
        String suggestedDealership = myDealer.getDealershipName();
        String suggestedDealershipURL = myDealer.getDealershipURL();

        Intent intent = new Intent(this,DealerActivity.class);
        intent.putExtra("dealershipName", suggestedDealership);
        intent.putExtra("dealershipURL", suggestedDealershipURL);
        startActivity(intent);
    }
}
