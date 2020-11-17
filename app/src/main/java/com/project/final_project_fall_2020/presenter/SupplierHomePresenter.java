package com.project.final_project_fall_2020.presenter;

import android.content.Intent;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.view.supplier.BusinessAnalysisActivity;
import com.project.final_project_fall_2020.view.supplier.FeedbackManagementActivity;
import com.project.final_project_fall_2020.view.supplier.OrderManagementActivity;
import com.project.final_project_fall_2020.view.supplier.PostManagementActivity;

public class SupplierHomePresenter implements SupplierHomeActivityContract.Presenter {

    SupplierHomeActivityContract.View view;
    private DatabaseReference db;

    public SupplierHomePresenter(final SupplierHomeActivityContract.View view) {
        this.view = view;
        initComponents();
        db = FirebaseDatabase.getInstance().getReference();
        // loadDataToSpDashBoard();
        //spinnerChangeItemAction();
    }

    private void initComponents() {
        cardBAManagementOnclicked();
        cardFeedBackManagementOnclicked();
        cardOrderManagementOnclicked();
        cardPostManagementOnclicked();
    }

    @Override
    public void cardOrderManagementOnclicked() {
        view.getOrderManagementCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), OrderManagementActivity.class);
                view.StartActivity(intent);
            }
        });

    }

    @Override
    public void cardPostManagementOnclicked() {
        view.getPostManagementCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), PostManagementActivity.class);
                view.StartActivity(intent);
            }
        });

    }

    @Override
    public void cardFeedBackManagementOnclicked() {
        view.getFeedbackManagementCard().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), FeedbackManagementActivity.class);
                view.StartActivity(intent);
            }
        });

    }

}
