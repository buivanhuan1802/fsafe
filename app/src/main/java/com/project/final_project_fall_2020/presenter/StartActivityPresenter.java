package com.project.final_project_fall_2020.presenter;


import android.view.View;
import android.widget.Button;

//this present to start activity
public class StartActivityPresenter implements StartActivityContract.Presenter {
    private StartActivityContract.View view;

    public StartActivityPresenter(StartActivityContract.View view) {
        this.view = view;
    }
}
