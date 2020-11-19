package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public interface SupplierCreatePostActivityContract {
    interface View {
        EditText getEdtPostTitle();

        EditText getEdtPostContent();

        EditText getEdtPostStartTime();

        EditText getEdtPostEndTime();

        ImageView getPostBanner();

        Button getPostSaveButton();

        Button getPostCancelButton();

        void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data);

        Context getContext();

        Activity getActivity();
    }

    interface Presenter {
        void btnSaveAction();

        void btnCancelAction();

        void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data);

        void onClickImageView();
    }
}
