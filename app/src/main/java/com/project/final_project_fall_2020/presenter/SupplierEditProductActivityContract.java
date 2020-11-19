package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

import com.project.final_project_fall_2020.model.Product;

public interface SupplierEditProductActivityContract {
    interface View {
        Button getBtnSave();

        Button getBtnDelete();

        ImageView getProductImageView();

        Context getConext();

        RadioGroup getRdioButtonGroup();

        void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data);

        Activity getActivity();

        Intent getPassedData();

        EditText getEdtProductName();

        EditText getEdtPrice();

        RadioButton rdDisable();

        RadioButton rdEnable();
    }

    interface Presenter {
        void chooseImage();

        String uploadImage();

        void setOnlickBtnSave();

        void setOnclickBtnDelete();

        void setOnclickProductUImageView();

        void setOncheckedChangeRdioGroup();

        void loadStartData();

        void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data);

        Product extractDataPassedFromProductListActivity(String data);
    }
}
