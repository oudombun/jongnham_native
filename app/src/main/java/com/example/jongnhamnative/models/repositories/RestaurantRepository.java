package com.example.jongnhamnative.models.repositories;


import androidx.lifecycle.MutableLiveData;

import com.example.jongnhamnative.models.Restaurant;
import com.example.jongnhamnative.models.services.DataSource;

import java.util.List;

public class RestaurantRepository {

    private static RestaurantRepository instance;
    private DataSource dataSource;


    public static RestaurantRepository getInstance(){
        if(instance==null){
            return new RestaurantRepository();
        }
        return instance;
    }

    private RestaurantRepository() {
        dataSource=new DataSource();
    }

    public MutableLiveData<List<Restaurant>> getRestaurant(){
        MutableLiveData<List<Restaurant>> data = new MutableLiveData<>();

        data.postValue(dataSource.getRestaurant());

        return data;
    }
}
