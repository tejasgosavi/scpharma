package com.thg.retailapp.domain.newlapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class navigationup extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final  int HOME_FRAGMENT = 0;
    private static final  int CART_FRAGMENT = 1;
    private static final  int ORDERS_FRAGMENT = 2;
    private static final  int ACCOUNT_FRAGMENT = 3;

    private FrameLayout frameLayout;
    private ImageView actionBarLogo;
    private static int currentFragment=-1;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        actionBarLogo = findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        frameLayout = findViewById(R.id.main_framelayout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment==HOME_FRAGMENT) {
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getMenuInflater().inflate(R.menu.navigationup, menu);
        }
            return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.search) {
            Intent searchIntent = new Intent(this,SearchActivity.class);
            startActivity(searchIntent);
            return true;
        }else if (id==R.id.action_settings){
            return true;
        }else if (id==R.id.main_cart){
            gotoFragment("My Cart",new MyCart(),CART_FRAGMENT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void gotoFragment(String Title, Fragment fragment, int fragmentNo){
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(Title);
        actionBarLogo.setVisibility(View.GONE);
        invalidateOptionsMenu();
        setFragment(fragment,fragmentNo);
      //  if (fragmentNo == CART_FRAGMENT) {
          //7   navigationView.getMenu().getItem(3).setChecked(true);
        //}
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new HomeFragment(),HOME_FRAGMENT);

        } else if (id == R.id.nav_inventory) {

        } else if (id == R.id.nav_orders) {
            gotoFragment("My Orders",new MyOrdersFragment(),ORDERS_FRAGMENT);

        } else if (id == R.id.nav_cart) {
            gotoFragment("My Cart",new MyCart(),CART_FRAGMENT);
        } else if (id == R.id.nav_account) {
            gotoFragment("My Account",new MyAccountFragment(),ACCOUNT_FRAGMENT);
        } else if (id == R.id.nav_logout){

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragment(Fragment fragment, int fragmentNo){
        currentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}