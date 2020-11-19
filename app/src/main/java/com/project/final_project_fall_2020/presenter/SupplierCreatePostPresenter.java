package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.PostDetail;
import com.project.final_project_fall_2020.utils.ImageProcessing;
import com.project.final_project_fall_2020.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SupplierCreatePostPresenter implements SupplierCreatePostActivityContract.Presenter {
    private SupplierCreatePostActivityContract.View view;
    private DatabaseReference db;
    private ImageProcessing imp;
    private Uri filePath;

    public SupplierCreatePostPresenter(SupplierCreatePostActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        this.imp = new ImageProcessing();
        initComponents();
    }

    void initComponents() {
        btnCancelAction();
        btnSaveAction();
        onClickImageView();
    }

    @Override
    public void btnSaveAction() {
        view.getPostSaveButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = view.getEdtPostTitle().getText().toString();
                String postContent = view.getEdtPostContent().getText().toString();
                String startTime = view.getEdtPostStartTime().getText().toString();
                String endTime = view.getEdtPostEndTime().getText().toString();
                String dateCreated = Utils.getSystemDate();
                String bannerUrl = imp.upLoadImageToCloud(filePath, view.getContext());
                DatabaseReference ref = db.child(Post.EntityName.TABLE_NAME);
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Post post = new Post();
                        post.setPostId(snapshot.getChildrenCount());
                        post.setPostTitle(title);
                        post.setPostContent(postContent);
                        post.setStartTime(startTime);
                        post.setEndTime(endTime);
                        post.setBannerurl(bannerUrl);
                        post.setDateCreated(dateCreated);
                        post.setDateUpdated(dateCreated);
                        post.setUserId(Utils.getLoginedUser(view.getContext()).getId());
                        post.setEnabled(true);
                        List<PostDetail> details = new ArrayList<>();
                        post.setDetails(details);
                        ref.child(post.getPostId() + "").setValue(post);
                        Toast.makeText(view.getContext(), "Save Successful !", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }

    @Override
    public void btnCancelAction() {

    }

    @Override
    public void onClickImageView() {
        view.getPostBanner().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imp.chooseImage(view.getActivity(), 71);
            }
        });
    }

    @Override
    public void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 71 && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(view.getContext().getContentResolver(), filePath);
                view.getPostBanner().setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
