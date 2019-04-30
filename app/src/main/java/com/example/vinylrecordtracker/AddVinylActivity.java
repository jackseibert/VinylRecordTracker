package com.example.vinylrecordtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddVinylActivity extends AppCompatActivity {

    Button btnSave;
    EditText txtArtist, txtAlbumName, txtCondition, txtDateBought, txtPrice, txtOtherNotes;
    //Double lattitude, longiture;
    VinylFirebaseData vinylDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // link each editText variable to the xml layout
        txtArtist = (EditText) findViewById(R.id.txtArtist);
        txtAlbumName = (EditText) findViewById(R.id.txtAlbumName);
        txtCondition = (EditText) findViewById(R.id.txtCondition);
        txtDateBought = (EditText) findViewById(R.id.txtDateBought);
        txtPrice = (EditText) findViewById(R.id.txtPrice);
        txtOtherNotes = (EditText) findViewById(R.id.txtOtherNotes);

        vinylDataSource = new VinylFirebaseData();
        vinylDataSource.open();

        // set up the button listener
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Add the vinyl to the database
                String artist = txtArtist.getText().toString();
                String albumName = txtAlbumName.getText().toString();
                String condition = txtCondition.getText().toString();
                String dateBought = txtDateBought.getText().toString();
                String price = txtPrice.getText().toString();
                String otherNotes = txtOtherNotes.getText().toString();
                vinylDataSource.createVinyl(artist, albumName, condition, dateBought, price, otherNotes);
                Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);
            }
        });

    }

}