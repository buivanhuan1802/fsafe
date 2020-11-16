package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;

import com.project.final_project_fall_2020.model.User;

public interface SupplierActivityContract {
    interface View {
        void initComponents();

        Button getBtnLogin();

        TextView getTextViewUserName();

        TextView getTextViewPassword();

        Context getContext();

        Resources getResource();

        void startActivity(Intent intent);

        Object getSystemService(String ct);
        SharedPreferences getSharedPreferences(String name, int mode);
    }

    interface Presenter {
        void btnLoginAction();

        String getLoginErrorMessage();
        void saveUserToPref(SharedPreferences pref ,User data);
    }
}
