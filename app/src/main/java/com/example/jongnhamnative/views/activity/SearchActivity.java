package com.example.jongnhamnative.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.jongnhamnative.R;
import com.example.jongnhamnative.views.fragment.ListRestaurantFragment;
import com.example.jongnhamnative.views.fragment.ListStaticDataRestaurant;
import com.example.jongnhamnative.views.fragment.MapRestaurantFragment;

public class SearchActivity extends AppCompatActivity {
    SearchView searchView;
    Toolbar toolbar;
    private ToggleButton toggleButton1;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_search);

        init();

        action();
    }


    private void init() {
        toolbar = findViewById(R.id.toolbar_top);
        toggleButton1=findViewById(R.id.toggleButton);
        searchView = findViewById(R.id.search_view);
        btnBack = findViewById(R.id.btnback);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        searchView.setQueryHint("Search");
        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = searchView.findViewById(id);
        textView.setTextColor(Color.GRAY);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.mylayout, new ListStaticDataRestaurant(), "TAG_A");
        fragmentTransaction.add(R.id.mylayout, new MapRestaurantFragment(), "TAG_B");

        fragmentTransaction.attach(new ListStaticDataRestaurant());

        fragmentTransaction.commit();


    }

    private void action(){
        btnBack.setOnClickListener(v->{
            finish();
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showListResult();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    switchToMap();
                }else{
                    showListResult();
                }
            }
        });
    }

    private void showListResult() {
        ListStaticDataRestaurant fragA = (ListStaticDataRestaurant) getSupportFragmentManager().findFragmentByTag("TAG_A");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(getSupportFragmentManager().findFragmentByTag("TAG_B"));
        fragmentTransaction.attach(fragA);
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commitAllowingStateLoss();
        getSupportFragmentManager().executePendingTransactions();
    }

    private void switchToMap() {
        MapRestaurantFragment fragB = (MapRestaurantFragment) getSupportFragmentManager().findFragmentByTag("TAG_B");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.detach(getSupportFragmentManager().findFragmentByTag("TAG_A"));
        fragmentTransaction.attach(fragB);
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commitAllowingStateLoss();
        getSupportFragmentManager().executePendingTransactions();
    }

}