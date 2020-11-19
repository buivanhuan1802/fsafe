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
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.OrderDetailPresenter;
import com.project.final_project_fall_2020.presenter.SupplierOrderDetailActivityContract;
import com.project.final_project_fall_2020.utils.SideMenuProcessing;
import com.project.final_project_fall_2020.utils.Utils;

public class DetailOrderActivity extends AppCompatActivity implements SupplierOrderDetailActivityContract.View, NavigationView.OnNavigationItemSelectedListener {
    SupplierOrderDetailActivityContract.Presenter presenter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private SideMenuProcessing sideMenuProcessing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        presenter = new OrderDetailPresenter(this);
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
    public Button getBtnAccept() {
        return findViewById(R.id.btnAcceptOrder);
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
    public Intent getPassedIntent() {
        return super.getIntent();
    }

    @Override
    public TextView getTextViewOrderId() {
        return findViewById(R.id.detailOrderId);
    }

    @Override
    public TextView getTextViewDateCreated() {
        return findViewById(R.id.detailDateCreated);
    }

    @Override
    public TextView getTextViewCreatedBy() {
        return findViewById(R.id.detailCreatedBy);
    }

    @Override
    public TextView getTextViewStatus() {
        return findViewById(R.id.detailStatus);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public TextView getTextViewAmountOrder() {
        return findViewById(R.id.detailTotalOrder);
    }

    @Override
    public ListView getListOrderDetail() {
        return findViewById(R.id.listViewOrderDetail);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}