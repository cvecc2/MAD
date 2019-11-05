package com.example.terriblehalloween;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saySpooky(View view) {
        //edit text
        EditText name = findViewById(R.id.editText);
        String nameValue = name.getText().toString();

        //text view
        TextView spookyText = findViewById(R.id.message);
        spookyText.setText("You Spooked " + nameValue + " out of their skin!");

        ImageView spookySkelly = findViewById(R.id.imageView);
        spookySkelly.setImageResource(R.drawable.scaryskelly);
    }
}
