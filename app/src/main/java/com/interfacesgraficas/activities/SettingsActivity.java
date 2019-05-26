package com.interfacesgraficas.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.interfacesgraficas.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Enable return button
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        ab.setTitle("Ajustes");

        Fragment preferenceFragment = new SettingsFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.pref_container, preferenceFragment);
        ft.commit();
    }

    ////////////////////////
    //Menu Options Methods//
    ////////////////////////
    /**
     * Inflate the options menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Adds the menu buttons
        //getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    /**
     * Different options in the menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action of menu items
        finish();

        return super.onOptionsItemSelected(item);
    }
}