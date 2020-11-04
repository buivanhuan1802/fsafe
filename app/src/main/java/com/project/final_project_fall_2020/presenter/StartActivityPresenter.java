package com.project.final_project_fall_2020.presenter;


import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.AppRole;
import com.project.final_project_fall_2020.view.admin.AdminLoginActivity;
import com.project.final_project_fall_2020.view.supplier.LoginActivity;

import java.util.List;

//this present to start activity
public class StartActivityPresenter implements StartActivityContract.Presenter {
    private StartActivityContract.View view;
    private DatabaseReference db;

    public StartActivityPresenter(StartActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        view.initComponents();
        loadDataToSpinner();
        btnContinueAction();
    }

    @Override
    public void loadDataToSpinner() {
        db.child("app_role").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<List<AppRole>> typeIndicator = new GenericTypeIndicator<List<AppRole>>() {
                };
                List<AppRole> roles = snapshot.getValue(typeIndicator);
                if (!roles.isEmpty()) {
                    roles.remove(0);
                    ArrayAdapter<AppRole> adapter = new ArrayAdapter<>(view.getContext(), R.layout.custom_spinner_text, roles);
                    view.getAppRoleSpinner().setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void btnContinueAction() {
        view.getBtnContinue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spAppRole = view.getAppRoleSpinner();
                AppRole role = (AppRole) spAppRole.getSelectedItem();
                Intent intent = null;
                switch (role.getRoleId()) {
                    case 1:
                        intent = new Intent(view.getContext(), AdminLoginActivity.class);
                        break;
                    case 2:
                        //   intent = new Intent(view.getContext(), AdminLoginActivity.class);
                        break;
                    case 3:
                        intent = new Intent(view.getContext(), LoginActivity.class);
                    default:
                        break;
                }
                if (intent != null)
                    view.startActivity(intent);
            }
        });

    }
}
