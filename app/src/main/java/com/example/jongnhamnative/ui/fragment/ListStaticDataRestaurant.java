package com.example.jongnhamnative.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jongnhamnative.R;
import com.example.jongnhamnative.util.StaticRestaurantProvider;
import com.example.jongnhamnative.data.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class ListStaticDataRestaurant extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.lis_static_restaurant, container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.list);
        StaticRestaurantProvider customAdapter = new StaticRestaurantProvider(getContext(), R.layout.list_restuarant_item, getStaticData());
        listView.setAdapter(customAdapter);
    }

    private List<Restaurant> getStaticData(){
        List<Restaurant> list = new ArrayList<>();
        list.add(new Restaurant("Cafe 1 ",R.drawable.img1));
        list.add(new Restaurant("Cafe 4 ",R.drawable.img2));
        list.add(new Restaurant("Cafe 2 ",R.drawable.img3));
        list.add(new Restaurant("Cafe 3 ",R.drawable.img4));
        return list;
    }
}
