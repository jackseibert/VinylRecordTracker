package com.example.vinylrecordtracker;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class VinylFirebaseData {
    DatabaseReference myVinylDbRef;
    public static final String VinylDataTag = "Vinyl Data";

    public DatabaseReference open() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myVinylDbRef = database.getReference(VinylDataTag);
        return myVinylDbRef;
    }

    public void close() {

    }

    public Vinyl createVinyl(String artist, String albumName, String condition, String dateBought, String price, String otherNotes) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = myVinylDbRef.child(VinylDataTag).push().getKey();
        //String key = "REPLACE THIS WITH KEY FROM DATABASE";
        // ---- set up the vinyl object
        Vinyl newVinyl = new Vinyl(key, artist, albumName, condition, dateBought, price, otherNotes);
        // ---- write the vote to Firebase
        myVinylDbRef.child(key).setValue(newVinyl);
        return newVinyl;
    }

    public Vinyl createVinyl(String artist, String albumName, String condition, String dateBought, String price, String otherNotes) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = myVinylDbRef.child(VinylDataTag).push().getKey();
        //String key = "REPLACE THIS WITH KEY FROM DATABASE";
        // ---- set up the vinyl object
        Vinyl newVinyl = new Vinyl(key, artist, albumName, condition, dateBought, price, otherNotes);
        // ---- write the vote to Firebase
        myVinylDbRef.child(key).setValue(newVinyl);
        return newVinyl;
    }

    public void deleteVinyl(Vinyl vinyl) {
        String key = vinyl.getKey();
        myVinylDbRef.child(key).removeValue();
    }

    public List<Vinyl> getAllVinyl(DataSnapshot dataSnapshot) {
        List<Vinyl> vinylList = new ArrayList<Vinyl>();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Vinyl vinyl = data.getValue(Vinyl.class);
            vinylList.add(vinyl);
        }
        return vinylList;
    }

}