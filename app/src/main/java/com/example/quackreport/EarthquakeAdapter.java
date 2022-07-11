package com.example.quackreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, int resource, @NonNull List<Earthquake> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);

        Earthquake currentQuack=getItem(position);

        TextView magView=(TextView) listItemView.findViewById(R.id.mag_Text_view);
        magView.setText(currentQuack.getMagnitude());

        TextView placeView=(TextView) listItemView.findViewById(R.id.place_Text_view);
        placeView.setText(currentQuack.getPlace());

        TextView dateView=(TextView) listItemView.findViewById(R.id.date_Text_view);
        dateView.setText(currentQuack.getDate());

        return listItemView;
    }
}
