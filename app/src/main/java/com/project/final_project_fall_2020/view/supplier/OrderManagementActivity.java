package com.project.final_project_fall_2020.view.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.SupplierOrderManagementActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierOrderManagementPresenter;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.OrderDetail;
import com.project.final_project_fall_2020.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManagementActivity extends AppCompatActivity implements SupplierOrderManagementActivityContract.View {
    SupplierOrderManagementActivityContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_management);
        presenter = new SupplierOrderManagementPresenter(this);

    }

    @Override
    public ListView getListDisplay() {
        return findViewById(R.id.listDisplayOrder);
    }

    @Override
    public Spinner getSpOrderStatus() {
        return findViewById(R.id.spOrderStatus);
    }

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}