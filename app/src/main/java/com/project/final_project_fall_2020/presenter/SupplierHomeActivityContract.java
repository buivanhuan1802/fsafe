package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.Spinner;

import androidx.cardview.widget.CardView;

public interface SupplierHomeActivityContract {
    interface View {
        Context getContext();

        Spinner getSpinner();

        FrameLayout getFrameLayout();

        Resources getResouces();

        void StartActivity(Intent intent);

        CardView getOrderManagementCard();

        CardView getPostManagementCard();

        CardView getFeedbackManagementCard();

        CardView getBusinessManagementCard();
    }

    interface Presenter {
        void cardOrderManagementOnclicked();

        void cardPostManagementOnclicked();

        void cardFeedBackManagementOnclicked();

        void cardBAManagementOnclicked();
    }
}
