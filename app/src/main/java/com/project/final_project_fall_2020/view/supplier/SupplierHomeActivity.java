package com.project.final_project_fall_2020.view.supplier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import android.widget.Spinner;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.OrderDetail;
import com.project.final_project_fall_2020.model.PostDetail;
import com.project.final_project_fall_2020.presenter.SupplierCreatePostPresenter;
import com.project.final_project_fall_2020.presenter.SupplierHomeActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierHomePresenter;
import com.project.final_project_fall_2020.utils.SideMenuProcessing;
import com.project.final_project_fall_2020.utils.Utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierHomeActivity extends AppCompatActivity implements SupplierHomeActivityContract.View, NavigationView.OnNavigationItemSelectedListener {

    private SupplierHomeActivityContract.Presenter presenter;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private SideMenuProcessing sideMenuProcessing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_home);

        presenter = new SupplierHomePresenter(this);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        sideMenuProcessing = new SideMenuProcessing();
        Utils.getLoginedUser(getApplicationContext());
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Xin Chào ," + Utils.getLoginedUser(getApplicationContext()).getFullName());

        //Navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

    }

    @Override
    public void onBackPressed() {
        //To avoid closing the application on Back pressed
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return sideMenuProcessing.onNavigationItemSelected(menuItem, this, drawerLayout, "2");
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public Spinner getSpinner() {
        return null;
    }

    @Override
    public FrameLayout getFrameLayout() {
        return null;
    }

    @Override
    public Resources getResouces() {
        return getResources();
    }

    @NonNull
    @Override
    public FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Override
    public void StartActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public CardView getOrderManagementCard() {
        return findViewById(R.id.cardOrderManagement);
    }

    @Override
    public CardView getPostManagementCard() {
        return findViewById(R.id.cardPostManagement);
    }

    @Override
    public CardView getFeedbackManagementCard() {
        return findViewById(R.id.cardFeedbackManagement);
    }

    @Override
    public CardView getBusinessManagementCard() {
        return findViewById(R.id.cardBA);
    }
}