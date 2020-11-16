package com.project.final_project_fall_2020.presenter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.OrderDetail;
import com.project.final_project_fall_2020.utils.CommonConstant;
import com.project.final_project_fall_2020.view.supplier.BusinessAnalysisFagment;
import com.project.final_project_fall_2020.view.supplier.FeedBackFagment;
import com.project.final_project_fall_2020.view.supplier.PostManagerFagement;
import com.project.final_project_fall_2020.view.supplier.SupplierNewOrder;

import java.util.ArrayList;
import java.util.List;

public class SupplierHomePresenter implements SupplierHomeActivityContract.Presenter {

    SupplierHomeActivityContract.View view;
    private DatabaseReference db;
    public SupplierHomePresenter(final SupplierHomeActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        loadDataToSpDashBoard();
        spinnerChangeItemAction();
    }

    @Override
    public void loadDataToSpDashBoard() {
        String[] arr = view.getResouces().getStringArray(R.array.spSupplierDashBoard);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), R.layout.custom_spinner_text, arr);
        view.getSpinner().setAdapter(adapter);
    }

    @Override
    public void spinnerChangeItemAction() {
        view.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            final String tag = view.getSpinner().getSelectedItem().toString();

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fagmentSelection(position, tag);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void fagmentSelection(int position, String tag) {
        Fragment selected;
        switch (position) {
            case 0:
                selected = new SupplierNewOrder();
                break;
            case 1:
                selected = new PostManagerFagement();
                break;
            case 2:
                selected = new FeedBackFagment();
                break;
            case 3:
                selected = new BusinessAnalysisFagment();
                break;
            default:
                selected = new SupplierNewOrder();
                break;
        }
        FragmentManager fm = view.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        try {
            Fragment currentFagment = fm.findFragmentByTag(CommonConstant.CURRENT_FAGMENT);
            transaction.remove(currentFagment);
            transaction.add(R.id.frameLayout, selected, tag);
            transaction.commit();
            CommonConstant.CURRENT_FAGMENT = tag;
        } catch (Exception e) {
            transaction.add(R.id.frameLayout, new SupplierNewOrder(), tag);
            transaction.commit();
            CommonConstant.CURRENT_FAGMENT = tag;
        }

    }
}
