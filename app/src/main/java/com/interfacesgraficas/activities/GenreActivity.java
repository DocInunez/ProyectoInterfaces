package com.interfacesgraficas.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.Toast;

import com.interfacesgraficas.R;

public class GenreActivity extends AppCompatActivity
{
    private Context context;
    private Toolbar mTopToolbar;
    private SearchView mSearchView;
    private MenuItem searchItem;

    private DrawerLayout drawerLayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_navdraw);

        context = this;

        mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        mTopToolbar.setTitle("Acción");
        setSupportActionBar(mTopToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Menu lateral
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        ActionBarDrawerToggle mToggle = new ActionBarDrawerToggle(this, drawerLayout, mTopToolbar, R.string.hide_bottom_view_on_scroll_behavior, R.string.hide_bottom_view_on_scroll_behavior);
        mToggle.setDrawerIndicatorEnabled(false);
        mToggle.syncState();
        mToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Backpress action
                finish();
            }
        });
        drawerLayout.setDrawerListener(mToggle);

        /*navView = (NavigationView)findViewById(R.id.navview);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.menu_seccion_0:
                                Intent it = new Intent(GenreActivity.this, MainActivity.class);
                                startActivity(it);

                                finish();
                                break;
                            case R.id.menu_seccion_2:
                                break;
                            case R.id.menu_opcion_1:
                                break;
                            case R.id.menu_opcion_2:
                                Intent it2 = new Intent(GenreActivity.this, LoginActivity.class);
                                startActivity(it2);

                                finish();
                                break;
                        }

                        drawerLayout.closeDrawers();

                        return true;
                    }
                });*/

        //Cerrar buscador
        mSearchView = (SearchView) findViewById(R.id.app_bar_search);

        //Acceso a pelicula
        ImageView iv = findViewById(R.id.ImageView01);
        iv.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent ev)
            {
                Intent it = new Intent(GenreActivity.this, MovieActivity.class);
                startActivity(it);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        searchItem = menu.findItem(R.id.app_bar_search);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.app_bar_search) {
            Toast.makeText(GenreActivity.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        if(id == 16908332){
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
