package com.project.final_project_fall_2020.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.StartActivityContract;
import com.project.final_project_fall_2020.presenter.StartActivityPresenter;

public class StartActivity extends AppCompatActivity implements StartActivityContract.View, View.OnClickListener {
    private StartActivityContract.Presenter presenter;
    private Spinner spAppRole;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        presenter = new StartActivityPresenter(this);


    }


    @Override
       public void onClick(View v) {

    }


    @Override
    public void initComponents() {
        spAppRole = findViewById(R.id.spRole);
        btnContinue = findViewById(R.id.btnContinue);

    }

    @Override
    public Object getSystemService(@NonNull String name) {
        return super.getSystemService(name);
    }

    @Override
    public Spinner getAppRoleSpinner() {
        return spAppRole;
    }

    @Override
    public Button getBtnContinue() {
        return btnContinue;
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}