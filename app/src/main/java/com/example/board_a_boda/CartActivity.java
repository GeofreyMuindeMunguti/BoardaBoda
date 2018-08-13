package com.example.board_a_boda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<CartItem> cartItems;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cartItems = new ArrayList<>();
        recyclerView = findViewById(R.id.cart_recyclerview);

        cartItems.add(new CartItem("Omo"," 100","200",R.drawable.omo));
        cartItems.add(new CartItem("Milk"," 50","171",R.drawable.milk));

        cartItems.add(new CartItem("Weetabix"," 120","332",R.drawable.weetabix));

        cartItems.add(new CartItem("Bread"," 50","77",R.drawable.bread));

        cartItems.add(new CartItem("Rice"," 130","111",R.drawable.rice));

        cartItems.add(new CartItem("Omo"," 100","200",R.drawable.omo));
        cartItems.add(new CartItem("Milk"," 50","171",R.drawable.milk));

        cartItems.add(new CartItem("Weetabix"," 120","332",R.drawable.weetabix));

        cartItems.add(new CartItem("Bread"," 50","77",R.drawable.bread));

        cartItems.add(new CartItem("Rice"," 130","111",R.drawable.rice));










        CartItemRecyclerViewAdapter myadapter = new CartItemRecyclerViewAdapter(CartActivity.this,cartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
        recyclerView.setAdapter(myadapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String[] arraySpinner = new String[] {
                "Breakfast", "Groceries", "Electronics", "Clothes", "Shoes"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner_cart);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            startActivity(new Intent(CartActivity.this,SettingsActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(CartActivity.this, MainActivity.class));
            // Handle the camera action
        } else if (id == R.id.nav_shop) {
            startActivity(new Intent(CartActivity.this, CartActivity.class));

        }

         else if (id == R.id.nav_settings) {
            startActivity(new Intent(CartActivity.this, SettingsActivity.class));

        } else if (id == R.id.nav_share) {
            shareIt();

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void shareIt() {
//sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Hey try our new shopping app:App_link_goes_in.here";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, " New shopping app!!");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));


    }
}
