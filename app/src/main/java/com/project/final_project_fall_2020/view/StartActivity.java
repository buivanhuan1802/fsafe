package com.project.final_project_fall_2020.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.StartActivityContract;
import com.project.final_project_fall_2020.presenter.StartActivityPresenter;
public class StartActivity extends AppCompatActivity implements StartActivityContract.View, View.OnClickListener {
    private Button btnLoginSupplier;
    private StartActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        presenter = new StartActivityPresenter(this);
        initComponents();
        btnLoginSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void initComponents() {
        btnLoginSupplier = findViewById(R.id.btnLoginAsSupplier);
    }
}