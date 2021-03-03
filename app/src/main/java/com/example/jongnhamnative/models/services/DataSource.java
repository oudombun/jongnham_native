package com.example.jongnhamnative.models.services;

import com.example.jongnhamnative.R;
import com.example.jongnhamnative.models.Restaurant;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public List<Restaurant> getRestaurant() {
        List<Restaurant> list = new ArrayList<>();
        list.add(new Restaurant("Amazon ", R.drawable.img1,new LatLng(11.551637, 104.936842)));
        list.add(new Restaurant("Brown Cafe ",R.drawable.img2,new LatLng(11.574767, 104.916431)));
        list.add(new Restaurant("Library Cafe ",R.drawable.img3,new LatLng(11.566796, 104.923987)));
        list.add(new Restaurant("Toulesour Cafe",R.drawable.img4,new LatLng(11.549444, 104.939349)));
        return list;
    }
}