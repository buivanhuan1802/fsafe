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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.presenter.SupplierEditProductActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierEditProductPresenter;

public class SupplierEditProductActivity extends AppCompatActivity implements SupplierEditProductActivityContract.View {
    SupplierEditProductActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_edit_product);
        presenter = new SupplierEditProductPresenter(this);

    }

    @Override
    public Spinner spCategory() {
        return findViewById(R.id.spEditCategory);
    }

    @Override
    public Intent getPassedData() {
        return getIntent();
    }

    @Override
    public EditText getEdtProductName() {
        return findViewById(R.id.edtEditProductName);
    }

    @Override
    public EditText getEdtPrice() {
        return findViewById(R.id.edtEditProductPrice);
    }

    @Override
    public RadioButton rdDisable() {
        return findViewById(R.id.rdiDisable);
    }

    @Override
    public RadioButton rdEnable() {
        return findViewById(R.id.rdiEnable);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityForResult(requestCode, resultCode, data);
    }

    @Override
    public Activity getActivity() {
        return this;
    }


    @Override
    public Button getBtnSave() {
        return findViewById(R.id.btnPostSave);
    }

    @Override
    public Button getBtnDelete() {
        return findViewById(R.id.btnPostCancel);
    }

    @Override
    public ImageView getProductImageView() {
        return findViewById(R.id.imvPostBanner);
    }

    @Override
    public Context getConext() {
        return getApplication();
    }

    @Override
    public RadioGroup getRdioButtonGroup() {
        return findViewById(R.id.rdiProductStatus);
    }

    @Override
    public void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


}