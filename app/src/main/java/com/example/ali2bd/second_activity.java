package com.example.ali2bd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.ali2bd.Fragments.Account;
import com.example.ali2bd.Fragments.Cart;
import com.example.ali2bd.Fragments.Home;
import com.example.ali2bd.Fragments.Products;
import com.example.ali2bd.Fragments.Store;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class second_activity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private Toolbar hometoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        hometoolbar =(Toolbar) findViewById(R.id.toolbar_home);
        Fragment fragment = null;
        final FragmentManager fm = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigatin_bar_id);
        //loading the default fragmen
        //getting bottom navigation view and attaching the listener
        bottomNavigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);

        setSupportActionBar(hometoolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        hometoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //for auto show search screen
        fragment = new Home();
        loadFragment(fragment);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home_buttom:
                fragment = new Home();

                break;

            case R.id.Store_buttom:
                fragment = new Store();
                break;

            case R.id.Products_buttom:
                fragment = new Products();
                break;
            case R.id.Cart_buttom:
                fragment = new Cart();
                break;
            case R.id.Account_buttom:
                fragment = new Account();
                break;


        }

        return loadFragment(fragment);
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_id, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
