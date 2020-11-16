package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.Spinner;

import androidx.fragment.app.FragmentManager;

public interface SupplierHomeActivityContract {
    interface View {
        Context getContext();

        Spinner getSpinner();

        FrameLayout getFrameLayout();

        Resources getResouces();
        FragmentManager getSupportFragmentManager();
    }

    interface Presenter {
        void loadDataToSpDashBoard();

        void spinnerChangeItemAction();
        void fagmentSelection(int position, String tag);
    }
}
