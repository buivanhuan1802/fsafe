package com.project.final_project_fall_2020.presenter;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.view.customer.DrinkAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.FastFoodAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.OfficeMealAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ServiceAsCustomerActivity;

public class CustomerHomePresenter implements CustomerHomeActivityContract.Presenter {
    CustomerHomeActivityContract.View view;
    private DatabaseReference db;

    public CustomerHomePresenter(CustomerHomeActivityContract.View view) {
        this.view = view;
        initComponents();
        db = FirebaseDatabase.getInstance().getReference();
    }

    private void initComponents() {
        cardOfficeMealOnclick();
        cardFastFoodOnclick();
        cardOtherServiceOnclick();
        cardDrinkOnclick();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        view.getDrawerLayout();
        return true;
    }

    @Override
    public void cardOfficeMealOnclick() {
        view.getOfficeMealCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), OfficeMealAsCustomerActivity.class);
                view.startActivity(intent);
            }
        });

    }

    @Override
    public void cardFastFoodOnclick() {
        view.getFastFoodCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), FastFoodAsCustomerActivity.class);
                view.startActivity(intent);
            }
        });
    }

    @Override
    public void cardOtherServiceOnclick() {
        view.getOtherServiceCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), ServiceAsCustomerActivity.class);
                view.startActivity(intent);
            }
        });
    }

    @Override
    public void cardDrinkOnclick() {
        view.getDrinkCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), DrinkAsCustomerActivity.class);
                view.startActivity(intent);
            }
        });
    }
}
