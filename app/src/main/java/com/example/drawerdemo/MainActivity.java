package com.example.drawerdemo;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener Clicker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            drawerLayout.closeDrawers();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialActionBar();
        InitialComponent();
    }

    private void initialActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    private void InitialComponent() {
        drawerLayout = findViewById(R.id.drawerLayout);
        btnCloseMenu = findViewById(R.id.btnCloseMenu);
        btnCloseMenu.setOnClickListener(Clicker);
        btnCloseRightMenu = findViewById(R.id.btnCloseRightMenu);
        btnCloseRightMenu.setOnClickListener(Clicker);
        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                R.string.app_name,
                R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(MainActivity.this,"menu open",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(MainActivity.this,"menu close",Toast.LENGTH_SHORT).show();
            }
        };

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(drawerToggle);

    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    Button btnCloseMenu, btnCloseRightMenu;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
}
