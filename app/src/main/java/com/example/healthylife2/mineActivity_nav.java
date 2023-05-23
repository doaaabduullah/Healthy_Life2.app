package com.example.healthylife2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class mineActivity_nav extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Home");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_nav);

        drawerLayout = findViewById(R.id.nev_main);
        Toolbar toolbar = findViewById(R.id.Toolbar);


        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new Home_Fragment());


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_draw_open, R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.Toolbar);
        switch (menuItem.getItemId())
        {
            case R.id.anemia:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new anemia_fragment()).commit();
                toolbar.setTitle("Anemia Diet");
                break;
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Home_Fragment()).commit();
                toolbar.setTitle("Home");
                break;
            case R.id.blood_pressure:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new blood_pressure_Fragment()).commit();
                toolbar.setTitle("Blood Pressure Diet");
                break;
            case R.id.drinks:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Fat_burning_drinks()).commit();
                toolbar.setTitle("Fat Burning Drinks");
                break;
            case R.id.loss_weight:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new loss_weight()).commit();
                toolbar.setTitle("Loss Weight");
                break;

            case R.id.Osteoporosis:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Osteoporosis_Fragment()).commit();
                toolbar.setTitle("Osteoporosis Diet");
                break;


            case R.id.contactus:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new contactus()).commit();
                toolbar.setTitle("Contact Us");
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }
}



