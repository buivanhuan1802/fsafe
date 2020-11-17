package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.ListView;

public interface SupplierOrderManagementActivityContract {
    interface View {
        ListView getListDisplay();

        CheckBox getCheckBookProcessing();

        CheckBox getCheckBookOnDelivery();


        CheckBox getCheckBookFinished();

        Context getContext();
    }

    interface Presenter {
        void loadDataToListDisplay(String[] wishes);

        void listDisplayOnclicked();

        void cbProcessingChangeState();

        void cbOndeliveryChangeState();

        void cbFinisedChangeState();
        void loadDataToView();
    }
}
