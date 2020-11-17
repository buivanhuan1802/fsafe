package com.project.final_project_fall_2020.view.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ListView;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.SupplierOrderManagementActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierOrderManagementPresenter;

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
    public CheckBox getCheckBookProcessing() {
        return findViewById(R.id.cbProcessing);
    }

    @Override
    public CheckBox getCheckBookOnDelivery() {
        return findViewById(R.id.cbOnDelivery);
    }

    @Override
    public CheckBox getCheckBookFinished() {
        return findViewById(R.id.cbFinished);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}