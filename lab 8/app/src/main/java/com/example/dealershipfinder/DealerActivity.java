package com.example.dealershipfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DealerActivity extends AppCompatActivity {
    private String dealership;
    private String dealershipURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });

        Intent intent = getIntent();
        dealership = intent.getStringExtra("dealershipName");
        dealershipURL = intent.getStringExtra("dealershipURL");

        TextView messageView = findViewById(R.id.dealershipTextView);
        messageView.setText("For a new car, you should visit " + dealership +". Click the button below to visit their website.");
    }

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(dealershipURL));
        startActivity(intent);

    }
}
