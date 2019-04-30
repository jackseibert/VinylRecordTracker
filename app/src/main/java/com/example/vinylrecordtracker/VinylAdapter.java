package com.example.vinylrecordtracker;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class VinylAdapter extends ArrayAdapter<Vinyl> {

    private List<Vinyl> vinylList;            // The list of vinyl to display
    private Context context;                // The original activity that displays this
    private int layoutResource;                   // the layout to use

    /**
     *   Basic constructor
     * @param context - The activity calling this
     * @param resource  The layout to use to display
     * @param vinylList  The list of vinyl to display
     */
    public VinylAdapter(Context context, int resource, List<Vinyl> vinylList) {
        super(context, resource, vinylList);
        this.context = context;
        this.layoutResource = resource;
        this.vinylList = vinylList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the vinyl we are displaying
        Vinyl vinyl = vinylList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //view = inflater.inflate(R.layout.vinyl_row_layout, null);
        view = inflater.inflate(R.layout.vinyl_row_layout, null);

        TextView txtArtist=(TextView)view.findViewById(R.id.txtArtist);
        TextView txtAlbumName=(TextView)view.findViewById(R.id.txtAlbumName);
        TextView txtCondition=(TextView)view.findViewById(R.id.txtCondition);
        TextView txtDateBought=(TextView)view.findViewById(R.id.txtDateBought);
        TextView txtPrice=(TextView)view.findViewById(R.id.txtPrice);
        TextView txtOtherNotes=(TextView)view.findViewById(R.id.txtOtherNotes);

        txtArtist.setText(vinyl.getArtist());
        txtAlbumName.setText(vinyl.getAlbumName());
        txtCondition.setText(vinyl.getCondition());
        txtDateBought.setText(vinyl.getDateBought());
        txtPrice.setText(vinyl.getPrice());
        txtOtherNotes.setText(vinyl.getOtherNotes());

        return(view);
    }


}