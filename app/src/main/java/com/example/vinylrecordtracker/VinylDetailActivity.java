package com.example.vinylrecordtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VinylDetailActivity extends AppCompatActivity {


    Button btnBack;
    EditText txtArtist, txtAlbumName, txtCondition, txtDateBought, txtPrice, txtOtherNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        Vinyl vinyl = (Vinyl)   bundle.getSerializable("Vinyl");

        // link each editText variable to the xml layout
        txtArtist = (EditText) findViewById(R.id.txtArtist);
        txtAlbumName = (EditText) findViewById(R.id.txtAlbumName);
        txtCondition = (EditText) findViewById(R.id.txtCondition);
        txtDateBought = (EditText) findViewById(R.id.txtDateBought);
        txtPrice = (EditText) findViewById(R.id.txtPrice);
        txtOtherNotes = (EditText) findViewById(R.id.txtOtherNotes);

        txtArtist.setText(vinyl.getArtist());
        txtAlbumName.setText(vinyl.getAlbumName());
        txtCondition.setText(vinyl.getCondition());
        txtDateBought.setText(vinyl.getDateBought());
        txtPrice.setText(vinyl.getPrice());
        txtOtherNotes.setText(vinyl.getOtherNotes());

        // set up the button listener
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent mainActIntent = new Intent(view.getContext(), MainActivity.class);
                finish();
                startActivity(mainActIntent);
            }
        });

    }
}