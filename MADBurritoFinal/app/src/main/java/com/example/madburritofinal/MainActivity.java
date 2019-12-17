package com.example.madburritofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button burritoFinder;
    private EditText nameEntry;
    private ImageView burritoImage;
    private TextView burritoText;
    private String message;
    private ToggleButton foodType;
    private RadioGroup location;
    private Switch Spicy;
    private Spinner spinner;
    private Button findRestaurant;

    private FoodShops recommendedRestaurant = new FoodShops();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        burritoFinder = findViewById(R.id.button);
        nameEntry = findViewById(R.id.editText);
        burritoImage = findViewById(R.id.imageView);
        burritoText = findViewById(R.id.burritoText);
        foodType = findViewById(R.id.toggleButton);
        location = findViewById(R.id.RadioGroup);
        Spicy = findViewById(R.id.switch1);
        spinner = findViewById(R.id.spinner);
        findRestaurant = findViewById(R.id.findRestaurant);
        spinner=findViewById(R.id.spinner);
        String locationName = spinner.getSelectedItem().toString();
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findShop(v);
            }
        };
        findRestaurant.setOnClickListener(onclick);
    }

    public void burritoType(View view) {
        boolean food = foodType.isChecked();
        int location_id = location.getCheckedRadioButtonId();
        boolean hot = Spicy.isChecked();
        String locationName = spinner.getSelectedItem().toString();

        if (location_id == -1) {

            Context context = getApplicationContext();
            CharSequence text = "Please select a price range!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {

            if ((food) && (hot)) { //spicy burrito

                String nameValue = nameEntry.getText().toString();
                message = nameValue + " wants a spicy burrito from " + locationName;
                burritoText.setText(message);
                burritoImage.setImageResource(R.drawable.burrito);

            } else if (food) { //burrito

                String nameValue = nameEntry.getText().toString();
                message = nameValue + " wants a burrito from" + locationName;
                burritoText.setText(message);
                burritoImage.setImageResource(R.drawable.burrito);

            } else if (hot) { //spicy
                String nameValue = nameEntry.getText().toString();
                message = nameValue + " wants a spicy taco from " + locationName;
                burritoText.setText(message);
                burritoImage.setImageResource(R.drawable.taco);

            } else if ((hot) &! (food)) { //spicy taco
                String nameValue = nameEntry.getText().toString();
                message = nameValue + " wants a spicy taco from " + locationName;
                burritoText.setText(message);
                burritoImage.setImageResource(R.drawable.taco);

            } else { //taco
                String nameValue = nameEntry.getText().toString();
                message = nameValue + " wants a taco from " + locationName;
                burritoText.setText(message);
                burritoImage.setImageResource(R.drawable.taco);
            }
        }
    }
    private void findShop(View view) {
        Integer restaurant = spinner.getSelectedItemPosition();
        recommendedRestaurant.setRestaurantName(restaurant);
        String suggestedRestaurantName = recommendedRestaurant.getRestaurantName();
        String suggestedRestaurantURL = recommendedRestaurant.getRestaurantURL();

        Intent intent = new Intent(this, FoodActivity.class);
        intent.putExtra("restaurantName", suggestedRestaurantName);
        intent.putExtra("restaurantURL", suggestedRestaurantURL);
        startActivity(intent);
    }
}
