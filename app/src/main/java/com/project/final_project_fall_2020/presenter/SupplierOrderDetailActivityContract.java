package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.Intent;
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
    }

    interface Presenter {
        void initComponents();

        Order extractDataFromOrderManagement(String data);

        void setPassedDataToView();
    }
}
