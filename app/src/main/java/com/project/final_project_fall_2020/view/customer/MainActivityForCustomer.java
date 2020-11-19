package com.project.final_project_fall_2020.view.customer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.PostDetail;
import com.project.final_project_fall_2020.presenter.CustomerHomeActivityContract;
import com.project.final_project_fall_2020.presenter.CustomerHomePresenter;
import com.project.final_project_fall_2020.view.StartActivity;

public class MainActivityForCustomer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CustomerHomeActivityContract.View {

    CustomerHomeActivityContract.Presenter presenter;
    private TextView txtFullName;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //get firebase data
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_customer);
        presenter = new CustomerHomePresenter(this);
        txtFullName = findViewById(R.id.txtFullName);
        String name = "Hoang Dinh Viet";

        txtFullName.setText("Xin Chào " + name);

        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        Menu menu = navigationView.getMenu();

        //Navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user  = mAuth.getCurrentUser();
        Post post= new Post();

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
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_fastFood:
                Intent intent = new Intent(MainActivityForCustomer.this, FastFoodAsCustomerActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_officeMeal:
                Intent intent1 = new Intent(MainActivityForCustomer.this, OfficeMealAsCustomerActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_service:
                Intent intent2 = new Intent(MainActivityForCustomer.this, ServiceAsCustomerActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_profile:
                Intent intent3 = new Intent(MainActivityForCustomer.this, ProfileAsCustomerActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_logout:
                Intent intent4 = new Intent(MainActivityForCustomer.this, StartActivity.class);
                startActivity(intent4);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public CardView getOfficeMealCard() {
        return findViewById(R.id.cardOfficeMeal);
    }

    @Override
    public CardView getFastFoodCard() {
        return findViewById(R.id.cardFastFood);
    }

    @Override
    public CardView getOtherServiceCard() {
        return findViewById(R.id.cardOtherService);
    }

    @Override
    public CardView getDrinkCard() {
        return findViewById(R.id.cardDrink);
    }

    @Override
    public DrawerLayout getDrawerLayout() {
        return findViewById(R.id.drawer_layout);
    }
}