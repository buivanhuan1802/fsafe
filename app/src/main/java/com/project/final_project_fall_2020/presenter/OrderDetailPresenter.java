package com.project.final_project_fall_2020.presenter;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.User;

public class OrderDetailPresenter implements SupplierOrderDetailActivityContract.Presenter {
    SupplierOrderDetailActivityContract.View view;
    DatabaseReference db;

    public OrderDetailPresenter(SupplierOrderDetailActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        initComponents();
    }

    @Override
    public void initComponents() {
        setPassedDataToView();
    }

    @Override
    public Order extractDataFromOrderManagement(String data) {
        Order order = null;
        try {
            Gson gson = new Gson();
            order = gson.fromJson(data, Order.class);
        } catch (Exception e) {
            Toast.makeText(view.getContext(), "Opps!!! Something went wrong", Toast.LENGTH_LONG).show();
        }
        return order;
    }

    @Override
    public void setPassedDataToView() {
        String data = view.getPassedIntent().getStringExtra(SupplierOrderManagementPresenter.INTENT_KEY_TO_ORDER_DETAIL);
        if (data != null && !data.isEmpty()) {
            Order order = extractDataFromOrderManagement(data);
            view.getTextViewOrderId().setText(order.getId() + "");
            view.getTextViewDateCreated().setText(order.getDateCreated());
            String status = order.getStatus();
            view.getTextViewStatus().setText(status.equals("1") ? Order.STATUS.IN_PROCESSING : status.equals("2") ? Order.STATUS.ON_DELIVERY :
                    Order.STATUS.FINISHED);
            db.child(User.EntityName.TABLE_NAME).orderByChild(User.EntityName.ID).equalTo(order.getUserId()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.hasChild(User.EntityName.FULL_NAME)) {
                        String fName = snapshot.child(order.getUserId() + "").child(User.EntityName.FULL_NAME).getValue().toString();
                        view.getTextViewCreatedBy().setText(fName);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }

}
