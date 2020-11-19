package com.project.final_project_fall_2020.view.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Product;
import com.project.final_project_fall_2020.presenter.ListProductActivityContract;
import com.project.final_project_fall_2020.presenter.ListProductPresenter;

import java.util.ArrayList;
import java.util.List;

public class ListProductOfPostActivity extends AppCompatActivity implements ListProductActivityContract.View {
    ListProductActivityContract.Presenter presenter;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_of_post);
        presenter = new ListProductPresenter(this);

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public ListView getListProduct() {
        return findViewById(R.id.listProduct);
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
    public Intent getPassedIntent() {
        return super.getIntent();
    }

    @Override
    public Button getCreateButton() {
        return findViewById(R.id.btnAddProduct);
    }
}