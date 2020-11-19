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
import com.project.final_project_fall_2020.presenter.SupplierPostManagementActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierPostManagementPresenter;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.PostDetail;

import java.util.ArrayList;
import java.util.List;

public class PostManagementActivity extends AppCompatActivity implements SupplierPostManagementActivityContract.View {

    SupplierPostManagementActivityContract.Presenter presenter;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_management);
        presenter = new SupplierPostManagementPresenter(this);

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