package com.project.final_project_fall_2020.view.supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.OrderDetailPresenter;
import com.project.final_project_fall_2020.presenter.SupplierOrderDetailActivityContract;

public class DetailOrderActivity extends AppCompatActivity implements SupplierOrderDetailActivityContract.View {
    SupplierOrderDetailActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        presenter = new OrderDetailPresenter(this);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public Intent getPassedIntent() {
        return super.getIntent();
    }

    @Override
    public TextView getTextViewOrderId() {
        return findViewById(R.id.detailOrderId);
    }

    @Override
    public TextView getTextViewDateCreated() {
        return findViewById(R.id.detailDateCreated);
    }

    @Override
    public TextView getTextViewCreatedBy() {
        return findViewById(R.id.detailCreatedBy);
    }

    @Override
    public TextView getTextViewStatus() {
        return findViewById(R.id.detailStatus);
    }
}