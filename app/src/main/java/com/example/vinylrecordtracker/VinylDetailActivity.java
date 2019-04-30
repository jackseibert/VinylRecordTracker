package com.example.vinylrecordtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VinylDetailActivity extends AppCompatActivity {


    Button buttonBack;
    EditText editTextSpecies, editTextWeight, editTextDate, editTextLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        Fish fish = (Fish)   bundle.getSerializable("Fish");

        // link each editText variable to the xml layout
        editTextSpecies = (EditText) findViewById(R.id.editTextSpecies);
        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextLocation = (EditText) findViewById(R.id.editTextLocation);

        editTextSpecies.setText(fish.getSpecies());
        editTextWeight.setText(fish.getWeightInOz());
        editTextDate.setText(fish.getDateCaught());
        editTextLocation.setText(fish.getLocationCaughtLatitude() + " x " + fish.getLocationCaughtLongitude());

        // set up the button listener
        buttonBack = (Button) findViewById(R.id.buttonReturn);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);
            }
        });

    }
}