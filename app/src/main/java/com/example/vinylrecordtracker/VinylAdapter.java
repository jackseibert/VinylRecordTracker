package com.example.vinylrecordtracker;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tgibbons on 4/24/2018.
 */


public class VinylAdapter extends ArrayAdapter<Fish> {

    private List<Fish> fishList;            // The list of fish to display
    private Context context;                // The original activity that displays this
    private int layoutResource;                   // the layout to use

    /**
     *   Basic constructor
     * @param context - The activity calling this
     * @param resource  The layout to use to display
     * @param fishList  The list of fish to display
     */
    public FishAdapter(Context context, int resource, List<Fish> fishList) {
        super(context, resource, fishList);
        this.context = context;
        this.layoutResource = resource;
        this.fishList = fishList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the fish we are displaying
        Fish fish = fishList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //view = inflater.inflate(R.layout.fish_row_layout, null);
        view = inflater.inflate(R.layout.fish_row_layout, null);

        TextView tvSpecies=(TextView)view.findViewById(R.id.textViewSpecies);
        TextView tvWeight=(TextView)view.findViewById(R.id.textViewWeight);
        TextView tvDate=(TextView)view.findViewById(R.id.textViewDate);
        tvSpecies.setText(fish.getSpecies());
        tvWeight.setText(fish.getWeightInOz());
        tvDate.setText(fish.getDateCaught());

        return(view);
    }


}