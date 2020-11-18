package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.adapters.CustomOrderAdapter;
import com.project.final_project_fall_2020.model.AppRole;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.view.supplier.DetailOrderActivity;

import java.util.ArrayList;
import java.util.List;

public class SupplierOrderManagementPresenter implements SupplierOrderManagementActivityContract.Presenter {
    SupplierOrderManagementActivityContract.View view;
    public static final String INTENT_KEY_TO_ORDER_DETAIL = "ORDER";
    private DatabaseReference db;


    public SupplierOrderManagementPresenter(SupplierOrderManagementActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        initComponent();
    }

    private void initComponent() {
        loadDataToView();
        setValueToSpOrderStatus();
        spinnerSelectedChangeAction();
        onItemSpinnerClicked();
    }


    public void setValueToSpOrderStatus() {
        List<String> status = new ArrayList<>();
        status.add(Order.STATUS.IN_PROCESSING);
        status.add(Order.STATUS.ON_DELIVERY);
        status.add(Order.STATUS.FINISHED);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), R.layout.custom_spinner_text, status);
        view.getSpOrderStatus().setAdapter(adapter);
        view.getSpOrderStatus().setSelection(0);
    }

    @Override
    public void spinnerSelectedChangeAction() {
        view.getSpOrderStatus().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View a, int position, long id) {
                String selected = view.getSpOrderStatus().getSelectedItem().toString();
                switch (selected) {
                    case Order.STATUS.IN_PROCESSING:
                        filterOrderByStatus("1");
                        break;
                    case Order.STATUS.ON_DELIVERY:
                        filterOrderByStatus("2");
                        break;
                    case Order.STATUS.FINISHED:
                        filterOrderByStatus("3");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                view.getSpOrderStatus().setSelection(0);

            }
        });
    }

    @Override
    public void onItemSpinnerClicked() {
        view.getListDisplay().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Order order = (Order) view.getListDisplay().getAdapter().getItem(position);
                Intent intent = new Intent(view.getContext(), DetailOrderActivity.class);
                Gson gson = new Gson();
                String stringValue = gson.toJson(order);
                intent.putExtra(INTENT_KEY_TO_ORDER_DETAIL, stringValue);
                view.startActivity(intent);
            }
        });
    }

    @Override
    public void filterOrderByStatus(String status) {
        Query query = db.child(Order.EntityName.TABLE_NAME).orderByChild(Order.EntityName.STATUS).equalTo(status);
        if (query != null) {
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    GenericTypeIndicator<List<Order>> typeIndicator = new GenericTypeIndicator<List<Order>>() {
                    };
                    List<Order> orders = snapshot.getValue(typeIndicator);
                    if (orders == null) {
                        view.getListDisplay().setAdapter(null);
                        Toast.makeText(view.getContext(), "Nothing to Display", Toast.LENGTH_LONG).show();
                    } else {
                        orders.removeIf(x -> (x == null));
                        CustomOrderAdapter adapter = new CustomOrderAdapter(view.getActivity(), R.layout.custom_supplier_order_lisview, orders);
                        view.getListDisplay().setAdapter(adapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        } else {
            Toast.makeText(view.getContext(), "Nothing to Display", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void loadDataToView() {
        filterOrderByStatus("1");
    }

    public long count() {
        final long[] count = {0};
        db.child(Order.EntityName.TABLE_NAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                count[0] = snapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return count[0];
    }
}
