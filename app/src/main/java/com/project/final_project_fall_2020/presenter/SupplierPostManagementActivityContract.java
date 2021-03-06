package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;

public interface SupplierPostManagementActivityContract {
    interface View {
        ListView getListViewPost();

        Context getContext();

        Activity getActivity();

        void startActivity(Intent intent);

        Button getCreateButton();
    }

    interface Presenter {
        void loadDataToListView();

        void onlistItemClicked();

        void onBtnCreatePostAction();
    }
}
