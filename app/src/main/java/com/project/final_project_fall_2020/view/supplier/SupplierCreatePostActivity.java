package com.project.final_project_fall_2020.view.supplier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.utils.SideMenuProcessing;
import com.project.final_project_fall_2020.view.StartActivity;
import com.project.final_project_fall_2020.view.customer.FastFoodAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.MainActivityForCustomer;
import com.project.final_project_fall_2020.view.customer.OfficeMealAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ProfileAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ServiceAsCustomerActivity;

public class SupplierCreatePostActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private TextView txtName;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private SideMenuProcessing sideMenuProcessing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_create_post);
        sideMenuProcessing = new SideMenuProcessing();
        String name = "Hoang Dinh Viet";

        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);


        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();

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
        return sideMenuProcessing.onNavigationItemSelected(menuItem, this, drawerLayout);
    }
}