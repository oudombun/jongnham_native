package com.example.jongnhamnative.data;

import com.example.jongnhamnative.R;

public class Restaurant {
    String title;
    int image;

    public Restaurant(String title, int image) {
        this.title = title;
        this.image = image;
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
}