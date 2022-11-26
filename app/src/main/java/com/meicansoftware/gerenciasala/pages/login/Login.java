package com.meicansoftware.gerenciasala.pages.login;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.meicansoftware.gerenciasala.R;
import com.meicansoftware.gerenciasala.pages.courses.Courses;
import com.meicansoftware.gerenciasala.pages.events.Events;
import com.meicansoftware.gerenciasala.pages.home.Home;
import com.meicansoftware.gerenciasala.pages.reservations.Reservations;
import com.meicansoftware.gerenciasala.pages.signup.Signup;

public class Login extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    private Button btnToggleDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpToolbar();

        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_login:

                        Intent intent = new Intent(Login.this, Login.class);
                        startActivity(intent);
                        break;

                    case  R.id.nav_signup:
                        Intent intent2 = new Intent(Login.this, Signup.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_courses:
                        Intent intent3 = new Intent(Login.this, Courses.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_events:
                        Intent intent4 = new Intent(Login.this, Events.class);
                        startActivity(intent4);
                        break;

                    case R.id.nav_reservations:
                        Intent intent5 = new Intent(Login.this, Reservations.class);
                        startActivity(intent5);
                        break;

                    case R.id.nav_home:
                        Intent intent_home = new Intent(Login.this, Home.class);
                        startActivity(intent_home);
                        break;
                }
                return false;
            }
        });
    }

    public void darkbutton(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

    }

    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        actionBarDrawerToggle.syncState();

    }
}
