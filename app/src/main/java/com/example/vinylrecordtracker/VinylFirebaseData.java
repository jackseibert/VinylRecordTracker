package com.example.vinylrecordtracker;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgibbons on 4/24/2018.
 */

public class VinylFirebaseData {
    DatabaseReference myFishDbRef;
    public static final String FishDataTag = "Fish Data";

    public DatabaseReference open() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myFishDbRef = database.getReference(FishDataTag);
        return myFishDbRef;
    }

    public void close() {

    }

    public Fish createFish( String species, String weightInOz, String dateCaught) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = myFishDbRef.child(FishDataTag).push().getKey();
        //String key = "REPLACE THIS WITH KEY FROM DATABASE";
        // ---- set up the fish object
        Fish newFish = new Fish(key, species, weightInOz, dateCaught);
        // ---- write the vote to Firebase
        myFishDbRef.child(key).setValue(newFish);
        return newFish;
    }

    public Fish createFish( String species, String weightInOz, String dateCaught, String locationLatitude, String locationLongitude) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = myFishDbRef.child(FishDataTag).push().getKey();
        //String key = "REPLACE THIS WITH KEY FROM DATABASE";
        // ---- set up the fish object
        Fish newFish = new Fish(key, species, weightInOz, dateCaught, locationLatitude,locationLongitude);
        // ---- write the vote to Firebase
        myFishDbRef.child(key).setValue(newFish);
        return newFish;
    }

    public void deleteFish(Fish fish) {
        String key = fish.getKey();
        myFishDbRef.child(key).removeValue();
    }

    public List<Fish> getAllFish(DataSnapshot dataSnapshot) {
        List<Fish> fishList = new ArrayList<Fish>();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Fish fish = data.getValue(Fish.class);
            fishList.add(fish);
        }
        return fishList;
    }

}