package com.project.final_project_fall_2020.view.supplier;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.SupplierCreatePostActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierCreatePostPresenter;
import com.project.final_project_fall_2020.utils.SideMenuProcessing;
import com.project.final_project_fall_2020.view.StartActivity;
import com.project.final_project_fall_2020.view.customer.FastFoodAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.MainActivityForCustomer;
import com.project.final_project_fall_2020.view.customer.OfficeMealAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ProfileAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ServiceAsCustomerActivity;

public class SupplierCreatePostActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SupplierCreatePostActivityContract.View {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private SideMenuProcessing sideMenuProcessing;
    private SupplierCreatePostActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_create_post);
        sideMenuProcessing = new SideMenuProcessing();
        String name = "Hoang Dinh Viet";
        presenter = new SupplierCreatePostPresenter(this);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
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
        return sideMenuProcessing.onNavigationItemSelected(menuItem, this, drawerLayout,"2");
    }

    @Override
    public EditText getEdtPostTitle() {
        return findViewById(R.id.edtPostTitle);
    }


    @Override
    public EditText getEdtPostContent() {
        return findViewById(R.id.edtPostContent);
    }

    @Override
    public EditText getEdtPostStartTime() {
        return findViewById(R.id.edtStartTime);
    }

    @Override
    public EditText getEdtPostEndTime() {
        return findViewById(R.id.edtEndTime);
    }

    @Override
    public ImageView getPostBanner() {
        return findViewById(R.id.imvPostBanner);
    }

    @Override
    public Button getPostSaveButton() {
        return findViewById(R.id.btnPostSave);
    }

    @Override
    public Button getPostCancelButton() {
        return findViewById(R.id.btnPostCancel);
    }

    @Override
    public void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityForResult(requestCode, resultCode, data);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}