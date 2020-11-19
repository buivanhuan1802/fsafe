package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.adapters.CustomPostAdapter;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.User;
import com.project.final_project_fall_2020.utils.CommonConstant;

import java.util.List;


public class SupplierPostManagementPresenter implements SupplierPostManagementActivityContract.Presenter {

    SupplierPostManagementActivityContract.View view;
    DatabaseReference db;

    public SupplierPostManagementPresenter(SupplierPostManagementActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        initComponents();
    }

    public void initComponents() {
        loadDataToListView();
    }

    @Override
    public void loadDataToListView() {
        SharedPreferences sf = view.getContext().getSharedPreferences(CommonConstant.PREFERENCE_LOGINED, Context.MODE_PRIVATE);
        String data = sf.getString(CommonConstant.PREFERENCE_LOGINED, "");
        if (!data.equals("")) {
            Gson gson = new Gson();
            User logined = gson.fromJson(data, User.class);
            db.child(Post.EntityName.TABLE_NAME).orderByChild(Post.EntityName.SUPPLIER).equalTo(logined.getId()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    GenericTypeIndicator<List<Post>> typeIndicator = new GenericTypeIndicator<List<Post>>() {
                    };
                    List<Post> posts = snapshot.getValue(typeIndicator);
                    Toast.makeText(view.getContext(), "insde", Toast.LENGTH_LONG).show();
                    if (posts == null) {
                        Toast.makeText(view.getContext(), "Nothing to display", Toast.LENGTH_LONG).show();
                    } else {
                        posts.removeIf(x -> (x == null));
                        CustomPostAdapter adapter = new CustomPostAdapter(view.getActivity(), R.layout.custom_listview_post, posts);
                        view.getListViewPost().setAdapter(adapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        } else {

        }
    }
}
