package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.Product;

public interface SupplierCreateProductActivityContract {
    interface View {
        EditText edtProductName();

        EditText edtProductPrice();

        Button btnSave();

        Button btnCancel();

        Spinner spCategory();

        ImageView imgViewProduct();

        Activity getActivity();

        void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data);

        Context getContext();

        Intent getPassedData();
    }

    interface Presenter {
        void onClickImageView();

        void onClickBtnSave();

        void onClickBtnCancel();

        void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data);

        Post extractDataPassedFromProductListActivity(String data);

    }
}
