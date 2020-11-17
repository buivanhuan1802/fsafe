package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.project.final_project_fall_2020.model.AppRole;
import com.project.final_project_fall_2020.model.Order;

import java.util.List;

public class SupplierOrderManagementPresenter implements SupplierOrderManagementActivityContract.Presenter {
    SupplierOrderManagementActivityContract.View view;
    private DatabaseReference db;

    public SupplierOrderManagementPresenter(SupplierOrderManagementActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();

        listDisplayOnclicked();
    }

    @Override
    public void loadDataToListDisplay(String[] wishes) {

    }

    @Override
    public void listDisplayOnclicked() {

    }

    @Override
    public void cbProcessingChangeState() {

    }

    @Override
    public void cbOndeliveryChangeState() {

    }

    @Override
    public void cbFinisedChangeState() {

    }

    @Override
    public void loadDataToView() {

    }


}
