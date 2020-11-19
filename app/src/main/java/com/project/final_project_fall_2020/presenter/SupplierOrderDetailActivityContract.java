package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.project.final_project_fall_2020.model.Order;

public interface SupplierOrderDetailActivityContract {
    interface View {
        Context getContext();

        TextView getTextViewOrderId();

        TextView getTextViewDateCreated();

        TextView getTextViewCreatedBy();

        TextView getTextViewStatus();

        Intent getPassedIntent();

        Button getBtnAccept();

        void startActivity(Intent intent);

        ListView getListOrderDetail();

        Activity getActivity();

        TextView getTextViewAmountOrder();
    }

    interface Presenter {
        void initComponents();

        Order extractDataFromOrderManagement(String data);

        void btnAcceptAction();

        void setPassedDataToView();
    }
}
