package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public interface StartActivityContract {
    interface View {
        void initComponents();

        Spinner getAppRoleSpinner();

        Button getBtnContinue();

        Context getContext();

        void startActivity(Intent intent);
        Object getSystemService(String ct);
    }

    interface Presenter {
        void loadDataToSpinner();

        void btnContinueAction();

        boolean isNetWorkAvailable();
    }
}
