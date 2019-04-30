package com.example.vinylrecordtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddFishActivity extends AppCompatActivity {

    Button buttonSave;
    EditText editTextSpecies, editTextWeight, editTextDate;
    Double lattitude, longiture;
    FishFirebaseData fishDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fish);

        // link each editText variable to the xml layout
        editTextSpecies = (EditText) findViewById(R.id.editTextSpecies);
        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        editTextDate = (EditText) findViewById(R.id.editTextDate);

        fishDataSource = new FishFirebaseData();
        fishDataSource.open();

        // get the current location of the phone
//        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        Criteria criteria = new Criteria();
//        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
//        lattitude = location.getLatitude();
//        longiture = location.getLongitude();

        // set up the button listener
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Add the fish to the database
                String species = editTextSpecies.getText().toString();
                String weight = editTextWeight.getText().toString();
                String dateCaught = editTextDate.getText().toString();
                fishDataSource.createFish(species, weight, dateCaught);
//                fishDataSource.createFish(species, weight, dateCaught, lattitude.toString(), longiture.toString());
                Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);
            }
        });

    }

}