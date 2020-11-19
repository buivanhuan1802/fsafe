package com.project.final_project_fall_2020.view.supplier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.SupplierPostManagementActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierPostManagementPresenter;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.PostDetail;
import com.project.final_project_fall_2020.utils.SideMenuProcessing;
import com.project.final_project_fall_2020.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PostManagementActivity extends AppCompatActivity implements SupplierPostManagementActivityContract.View, NavigationView.OnNavigationItemSelectedListener {

    SupplierPostManagementActivityContract.Presenter presenter;
    DatabaseReference db;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private SideMenuProcessing sideMenuProcessing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_management);
        presenter = new SupplierPostManagementPresenter(this);
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
    public ListView getListViewPost() {
        return findViewById(R.id.listProduct);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public Button getCreateButton() {
        return findViewById(R.id.btnCreatePost);
    }
}