package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;

public interface SupplierOrderManagementActivityContract {
    interface View {
        ListView getListDisplay();

        Spinner getSpOrderStatus();

        Context getContext();

        Activity getActivity();

        void startActivity(Intent intent);

    }

    interface Presenter {


        void spinnerSelectedChangeAction();

        void onItemSpinnerClicked();

        void filterOrderByStatus(String status);

        void loadDataToView();
    }
}
