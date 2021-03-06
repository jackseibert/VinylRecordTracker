package com.example.vinylrecordtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created By: Jack Seibert
 * Created For: CIS 3334 Final Project
 * Last Modified: 5-6-2019
 */


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    Button btnNewAlbum, btnAlbumDetails, btnDeleteAlbum, btnSignOut;          // two button widgets
    ListView listViewVinyl;                                  // listview to display all the vinyl in the database
    ArrayAdapter<Vinyl> vinylAdapter;
    List<Vinyl> vinylList;
    VinylFirebaseData vinylDataSource;
    DatabaseReference myVinylDbRef;
    int positionSelected;
    Vinyl vinylSelected;

    /**
     * onCreate method for the Main Activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance(); //declare object for Firebase
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FirebaseAuth.getInstance().signOut();

        setupFirebaseDataChange();
        setupListView();
        setupAddButton();
        setupDetailButton();
        setupDeleteButton();
        setupSignOutButton();

        mAuthListener = new FirebaseAuth.AuthStateListener() { //initialized mAuthListener
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //track the user when they sign in or out using the firebaseAuth
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // User is signed out
                    Log.d("CSS3334","onAuthStateChanged - User NOT is signed in");
                    Intent signInIntent = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(signInIntent);
                }
            }
        };

    }

    /**
     * Set Up method for FirebaseDataChange
     */
    private void setupFirebaseDataChange() {
        vinylDataSource = new VinylFirebaseData();
        myVinylDbRef = vinylDataSource.open();
        myVinylDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()");        // debugging log
                vinylList = vinylDataSource.getAllVinyl(dataSnapshot);
                // Instantiate a custom adapter for displaying each vinyl
                vinylAdapter = new VinylAdapter(MainActivity.this, android.R.layout.simple_list_item_single_choice, vinylList);
                // Apply the adapter to the list
                listViewVinyl.setAdapter(vinylAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });
    }

    /**
     * Set Up method for ListView
     */
    private void setupListView() {
        listViewVinyl = (ListView) findViewById(R.id.ListViewVinyl);
        listViewVinyl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View parent,
                                    int position, long id) {
                positionSelected = position;
                Log.d("MAIN", "Vinyl selected at position " + positionSelected);
    }
});
    }

    /**
     * Set Up method for AddButton
     */
    private void setupAddButton() {
        // Set up the button to add a new vinyl using a separate activity
        btnNewAlbum = (Button) findViewById(R.id.btnNewAlbum);
        btnNewAlbum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Start up the add vinyl activity with an intent
                Intent detailActIntent = new Intent(view.getContext(), AddVinylActivity.class);
                finish();
                startActivity(detailActIntent);
            }
        });
    }

    /**
     * Set Up method for DetailButton
     */
    private void setupDetailButton() {
        // Set up the button to display details on one vinyl using a separate activity
        btnAlbumDetails = (Button) findViewById(R.id.btnAlbumDetails);
        btnAlbumDetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("MAIN", "onClick for Details");
                Intent detailActIntent = new Intent(view.getContext(), VinylDetailActivity.class);
                detailActIntent.putExtra("Vinyl", vinylList.get(positionSelected));
                finish();
                startActivity(detailActIntent);
            }
        });
    }

    /**
     * Set Up method for DeleteButton
     */
    private void setupDeleteButton() {
        // Set up the button to display details on one vinyl using a separate activity
        btnDeleteAlbum = (Button) findViewById(R.id.btnDeleteAlbum);
        btnDeleteAlbum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("MAIN", "onClick for Delete");
                Log.d("MAIN", "Delete at position " + positionSelected);
                vinylDataSource.deleteVinyl(vinylList.get(positionSelected));
                vinylAdapter.remove( vinylList.get(positionSelected) );
                vinylAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * Set Up method for SignOutButton
     */
    private void setupSignOutButton() {
        // Set up the button to display details on one vinyl using a separate activity
        btnSignOut = (Button) findViewById(R.id.btnSignOut);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);
    }

}