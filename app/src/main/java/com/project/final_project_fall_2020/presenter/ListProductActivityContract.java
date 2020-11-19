package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;

import com.project.final_project_fall_2020.model.Post;

public interface ListProductActivityContract {
    interface View {
        Context getContext();

        ListView getListProduct();

        Activity getActivity();

        void startActivity(Intent intent);

        Intent getPassedIntent();

        Button getCreateButton();
    }

    interface Presenter {
        void loadDataToListProduct();

        void onclickListProductItem();

        Post extractDataPassedFromPostActivity(String data);

        void onClickCreateProduct();
    }
}
