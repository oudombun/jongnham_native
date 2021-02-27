package com.example.jongnhamnative.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jongnhamnative.R;
import com.example.jongnhamnative.data.Restaurant;

import java.util.List;

public class StaticRestaurantProvider extends ArrayAdapter<Restaurant> {
    private int resourceLayout;
    private Context mContext;

    public StaticRestaurantProvider(Context context, int resource, List<Restaurant> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Restaurant p = getItem(position);

        if (p != null) {
            TextView tt1 = v.findViewById(R.id.title);
            ImageView tt2 = v.findViewById(R.id.imagevi);
            tt1.setText(p.getTitle());
            tt2.setBackgroundResource(p.getImage());
        }

        return v;
    }

}
