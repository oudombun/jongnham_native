package com.example.jongnhamnative.views.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.jongnhamnative.R;
import com.example.jongnhamnative.viewmodels.RestaurantViewModel;
import com.example.jongnhamnative.views.adapter.RestaurantAdapter;
import com.example.jongnhamnative.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class ListStaticDataRestaurant extends Fragment {
    View view;

    RestaurantViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.lis_static_restaurant, container,false);
        viewModel= ViewModelProviders.of(this).get(RestaurantViewModel.class);
        viewModel.init();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = view.findViewById(R.id.list);

        viewModel.getRestaurant().observe(getActivity(), new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurants) {
                RestaurantAdapter customAdapter = new RestaurantAdapter(getContext(), R.layout.list_restuarant_item, restaurants);
                listView.setAdapter(customAdapter);
            }
        });
    }

}
