package com.project.final_project_fall_2020.view.supplier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.OrderDetail;
import com.project.final_project_fall_2020.presenter.SupplierHomeActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierHomePresenter;
import com.project.final_project_fall_2020.utils.CommonConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplierHomeActivity extends AppCompatActivity implements SupplierHomeActivityContract.View {

    private SupplierHomeActivityContract.Presenter presenter;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_home);
        presenter = new SupplierHomePresenter(this);
        // db = FirebaseDatabase.getInstance().getReference();
        //  Map<String, Object> map = new HashMap<>();
        //  OrderDetail dt = new OrderDetail(1, 1, 1, 100.0);
        //  List<OrderDetail> lor = new ArrayList<>();
        //  lor.add(dt);
        // Order x = new Order(1, "1", "1", "2020", "1", lor);
        //  map.put("1", x);


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