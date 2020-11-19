package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import com.project.final_project_fall_2020.utils.Utils;
import com.project.final_project_fall_2020.view.supplier.CreateSupplierActivity;
import com.project.final_project_fall_2020.view.supplier.ListProductOfPostActivity;
import com.project.final_project_fall_2020.view.supplier.SupplierCreatePostActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SupplierPostManagementPresenter implements SupplierPostManagementActivityContract.Presenter {

    private SupplierPostManagementActivityContract.View view;
    private DatabaseReference db;
    public static final String INTENT_KEY_TO_LIST_PRODUCT = "POST";

    public SupplierPostManagementPresenter(SupplierPostManagementActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        db.keepSynced(true);
        initComponents();
    }

    public void initComponents() {
        loadDataToListView();
        onlistItemClicked();
        onBtnCreatePostAction();
    }

    @Override
    public void loadDataToListView() {
        User logined = Utils.getLoginedUser(view.getContext());
        if (logined != null) {
            db.child(Post.EntityName.TABLE_NAME).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    GenericTypeIndicator<Post> typeIndicator = new GenericTypeIndicator<Post>() {
                    };
                    List<Post> list = new ArrayList<>();
                    for (DataSnapshot dt : snapshot.getChildren()) {
                        Post post = dt.getValue(typeIndicator);
                        if (post.getUserId() == logined.getId() && post.isEnabled()) {
                            list.add(post);
                        }
                    }
                    if (list.isEmpty()) {
                        Toast.makeText(view.getContext(), "Nothing to display", Toast.LENGTH_LONG).show();
                    } else {
                        CustomPostAdapter adapter = new CustomPostAdapter(view.getActivity(), R.layout.custom_listview_post, list);
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

    @Override
    public void onlistItemClicked() {
        view.getListViewPost().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Post post = (Post) view.getListViewPost().getAdapter().getItem(position);
                Gson gson = new Gson();
                String data = gson.toJson(post);
                Intent intent = new Intent(view.getContext(), ListProductOfPostActivity.class);
                intent.putExtra(INTENT_KEY_TO_LIST_PRODUCT, data);
                view.startActivity(intent);
            }
        });
    }

    @Override
    public void onBtnCreatePostAction() {
        view.getCreateButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), SupplierCreatePostActivity.class);
                view.startActivity(intent);
            }
        });
    }
}
