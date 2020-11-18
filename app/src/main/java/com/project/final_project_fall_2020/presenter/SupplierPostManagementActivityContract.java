package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

public interface SupplierPostManagementActivityContract {
    interface View {
        ListView getListViewPost();

        Context getContext();

        Activity getActivity();
    }

    interface Presenter {
        void loadDataToListView();
    }
}
