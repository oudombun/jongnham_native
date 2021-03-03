package com.example.jongnhamnative.models;

import com.google.android.gms.maps.model.LatLng;

public class Restaurant {
    String title;
    int image;
    LatLng latLng;

    public Restaurant(String title, int image, LatLng latLng) {
        this.title = title;
        this.image = image;
        this.latLng = latLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
