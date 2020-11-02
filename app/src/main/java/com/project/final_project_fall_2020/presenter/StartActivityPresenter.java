package com.project.final_project_fall_2020.presenter;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.project.final_project_fall_2020.router.AppRouter;
import com.project.final_project_fall_2020.view.StartActivity;
import com.project.final_project_fall_2020.view.ViewInterface;
import com.project.final_project_fall_2020.router.AppRouter;
import com.project.final_project_fall_2020.view.supplier.LoginActivity;

//this present to start activity
public class StartActivityPresenter implements IStartActivityPresenter {
    private ViewInterface view;

    public StartActivityPresenter(ViewInterface view) {
        this.view = view;
    }


    @Override
    public void buttonLoginAsSupplierAction(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void buttonLoginAsCustomerAction(Button button) {

    }
}
