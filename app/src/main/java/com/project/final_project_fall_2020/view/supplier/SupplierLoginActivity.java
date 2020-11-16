package com.project.final_project_fall_2020.view.supplier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.SupplierActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierLoginPresenter;

public class SupplierLoginActivity extends AppCompatActivity implements SupplierActivityContract.View, View.OnClickListener {
    private Button btnLogin;
    private TextView txtUserName;
    private TextView txtPassword;
    private SupplierActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_login);
        presenter = new SupplierLoginPresenter(this);
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return super.getSharedPreferences(name, mode);
    }

    @Override
    public Resources getResource() {
        return super.getResources();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initComponents() {
        this.txtPassword = findViewById(R.id.txtPassword);
        this.txtUserName = findViewById(R.id.txtUserName);
        this.btnLogin = findViewById(R.id.btnLogin);
    }

    @Override
    public Button getBtnLogin() {
        return this.btnLogin;
    }

    @Override
    public TextView getTextViewUserName() {
        return this.txtUserName;
    }

    @Override
    public TextView getTextViewPassword() {
        return this.txtPassword;
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public Object getSystemService(@NonNull String name) {
        return super.getSystemService(name);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}