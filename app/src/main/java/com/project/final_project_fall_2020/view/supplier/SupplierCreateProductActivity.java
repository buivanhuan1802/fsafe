package com.project.final_project_fall_2020.view.supplier;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.SupplierCreateProductActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierCreateProductPresenter;

public class SupplierCreateProductActivity extends AppCompatActivity implements SupplierCreateProductActivityContract.View {
    SupplierCreateProductActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_create_product);
        presenter = new SupplierCreateProductPresenter(this);
    }

    @Override
    public EditText edtProductName() {
        return findViewById(R.id.edtCreateProductName);
    }

    @Override
    public EditText edtProductPrice() {
        return findViewById(R.id.edtCreateProductPrice);
    }

    @Override
    public Button btnSave() {
        return findViewById(R.id.btnCreateSave);
    }

    @Override
    public Button btnCancel() {
        return null;
    }

    @Override
    public Intent getPassedData() {
        return super.getIntent();
    }

    @Override
    public Spinner spCategory() {
        return findViewById(R.id.spCreateCategory);
    }

    @Override
    public ImageView imgViewProduct() {
        return findViewById(R.id.imvCreateProduct);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityForResult(requestCode, resultCode, data);
    }

    @Override
    public void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}