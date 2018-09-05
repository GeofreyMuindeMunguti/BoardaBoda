package com.example.board_a_boda;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import android.R.layout;

import static android.app.PendingIntent.getActivity;
import static com.example.board_a_boda.R.id.buy;


public class CartActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , CartItemRecyclerViewAdapter.ShoppingData {
    private List<CartItem> cartItems;
    private RecyclerView recyclerView;
    private Button buy;
    private TextView tv_itname;
    private Button btn_buy;
    private String shoppe;
   // BroadcastReceiver mMessageReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));

        cartItems = new ArrayList<>();
        recyclerView = findViewById(R.id.cart_recyclerview);

        cartItems.add(new CartItem("Omo"," 100","200","1",R.drawable.omo));
        cartItems.add(new CartItem("Milk"," 50","171","1",R.drawable.milk));

        cartItems.add(new CartItem("Weetabix"," 120","332","1",R.drawable.weetabix));

        cartItems.add(new CartItem("Bread"," 50","77","1",R.drawable.bread));

        cartItems.add(new CartItem("Rice"," 130","111","1",R.drawable.rice));






        CartItemRecyclerViewAdapter myadapter = new CartItemRecyclerViewAdapter(CartActivity.this,cartItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
        recyclerView.setAdapter(myadapter);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//               // String s = CartItemRecyclerViewAdapter.onBindViewHolder
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//                startActivity(new Intent(CartActivity.this,ShoppedActivity.class));
//            }
//        });

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
        if (id == R.id.action_login)
        {
            startActivity(new Intent(CartActivity.this,ActivityLogin.class));
            return  true;

        }

        return super.onOptionsItemSelected(item);
    }

  BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
          // Get extra data included in the Intent
          final String ItemName = intent.getStringExtra("item");
          final String qty = intent.getStringExtra("quantity");
          //Toast.makeText(CartActivity.this, ItemName + " " +qty,Toast.LENGTH_SHORT).show();
          shoppe = intent.getStringExtra("item");

          Log.d("Things",ItemName);
          Log.d("Total price",qty);





          FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
          fab.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  if (!ItemName.equals("[]")) {
                      AlertDialog.Builder builder;
                      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                          builder = new AlertDialog.Builder(CartActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                      } else {
                          builder = new AlertDialog.Builder(CartActivity.this);
                      }
                      builder.setTitle("Place Order")
                              .setMessage(ItemName +" \n")
                              .setPositiveButton(R.string.place, new DialogInterface.OnClickListener() {
                                  public void onClick(DialogInterface dialog, int which) {
                                      // continue with delete
                                      //place order

                                      AlertDialog.Builder builder;
                                      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                          builder = new AlertDialog.Builder(CartActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                                      } else {
                                          builder = new AlertDialog.Builder(CartActivity.this);
                                      }
                                      builder.setTitle("Order Placed")
                                              .setMessage("Your order was placed")
                                              .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                                  public void onClick(DialogInterface dialog, int which) {
                                                      startActivity(new Intent(CartActivity.this,CartActivity.class));

                                                  }
                                              })
                                              .setNegativeButton(R.string.view, new DialogInterface.OnClickListener() {
                                                  public void onClick(DialogInterface dialog, int which) {
                                                      int page = 2;
                                                      Intent intent = new Intent(CartActivity.this,MainActivity.class);
                                                      intent.putExtra("One", page);// One is your argument
                                                      startActivity(intent);
                                                  }
                                              })
                                              .setIcon(android.R.drawable.ic_dialog_info)
                                              .show();



                                  }
                              })
                              .setNegativeButton(R.string.edit, new DialogInterface.OnClickListener() {
                                  public void onClick(DialogInterface dialog, int which) {
                                       //do here
                                      //go edit
                                  }
                              })
                              .setIcon(R.drawable.ic_shopping)
                              .show();
                  }
                  else
                  {
                      Toast.makeText(CartActivity.this,"Nothing is picked",Toast.LENGTH_SHORT).show();
                  }
              }

          });
      }
  };



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

    @Override
    public void shoppinglstdata(Array[] shoppinglist) {
        String shoppe = shoppinglist.toString();
//        final Intent i = new Intent(this, ShoppedActivity.class);
//        i.putExtra("shoppe",shoppe);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                // String s = CartItemRecyclerViewAdapter.onBindViewHolder
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//                startActivity(i);
//            }
//        });



    }
}
