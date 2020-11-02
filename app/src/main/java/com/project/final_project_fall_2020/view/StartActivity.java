package com.project.final_project_fall_2020.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.entity.User;
import com.project.final_project_fall_2020.presenter.StartActivityPresenter;
import com.project.final_project_fall_2020.router.AppRouter;

import java.util.List;

public class StartActivity extends AppCompatActivity implements ViewInterface, View.OnClickListener {
    private Button btnLoginSupplier;
    private StartActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initItems();
        initPresenter();
        btnLoginSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new AppRouter(AppRouter.SUPPLIER_LOGIN_ROUTER, getApplicationContext()).getIntent();
                startActivity(intent);
            }
        });
    }


    @Override
    public void initItems() {
        btnLoginSupplier = findViewById(R.id.btnLoginAsSupplier);
    }

    @Override
    public void initPresenter() {
        presenter = new StartActivityPresenter(this);
    }


    @Override
    public void onClick(View v) {

    }
}