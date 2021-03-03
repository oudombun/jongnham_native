package com.example.jongnhamnative.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jongnhamnative.models.Restaurant;
import com.example.jongnhamnative.models.repositories.RestaurantRepository;

import java.util.List;

public class RestaurantViewModel extends ViewModel {
    private RestaurantRepository repository;

    public void init(){
        repository = RestaurantRepository.getInstance();
    }

    public LiveData<List<Restaurant>> getRestaurant(){
        MutableLiveData<List<Restaurant>> data;
        data = repository.getRestaurant();
        return data;
    }
}
