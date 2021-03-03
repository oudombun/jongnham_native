package com.example.jongnhamnative.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.jongnhamnative.R;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class HomeActivity extends AppCompatActivity {
    private static final String[] LOCATION =
            {Manifest.permission.ACCESS_FINE_LOCATION};

    private static final int RC_LOCATION_PERM = 124;
    Button btnsearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        askPermission();

        action();
    }

    @AfterPermissionGranted(RC_LOCATION_PERM)
    public void askPermission() {
        if (!hasLocationPermissions()){
            // Ask for both permissions
            EasyPermissions.requestPermissions(
                    this,
                    "We need your location to find nearest restaurant",
                    RC_LOCATION_PERM,
                    LOCATION);
        }
    }

    @AfterPermissionGranted(RC_LOCATION_PERM)
    private boolean hasLocationPermissions() {
        return EasyPermissions.hasPermissions(this, LOCATION);
    }

    private void init() {
        btnsearch= findViewById(R.id.btnsearch);
    }


    private void action() {
        btnsearch.setOnClickListener(v->{
            showSearchBox();
        });
    }
    private void showSearchBox(){
        Intent in = new Intent(HomeActivity.this, SearchActivity.class);
        startActivity(in);
    }




}