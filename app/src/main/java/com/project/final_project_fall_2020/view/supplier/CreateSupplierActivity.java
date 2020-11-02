package com.project.final_project_fall_2020.view.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.entity.User;
import com.project.final_project_fall_2020.view.ViewInterface;

import java.util.List;

public class CreateSupplierActivity extends AppCompatActivity implements ViewInterface, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_supplier);
        initItems();
        initPresenter();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initItems() {

    }

    @Override
    public void initPresenter() {

    }


}