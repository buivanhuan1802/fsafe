package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.project.final_project_fall_2020.model.Category;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.PostDetail;
import com.project.final_project_fall_2020.model.Product;
import com.project.final_project_fall_2020.model.User;
import com.project.final_project_fall_2020.utils.ImageProcessing;
import com.project.final_project_fall_2020.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SupplierCreateProductPresenter implements SupplierCreateProductActivityContract.Presenter {
    SupplierCreateProductActivityContract.View view;
    ImageProcessing imp;
    DatabaseReference db;
    Uri filePath;

    public SupplierCreateProductPresenter(SupplierCreateProductActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        imp = new ImageProcessing();
        initComponents();
    }

    void initComponents() {
        loadDataToSpinner();
        onClickBtnCancel();
        onClickBtnSave();
        onClickImageView();
    }

    @Override
    public void onClickImageView() {
        view.imgViewProduct().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imp.chooseImage(view.getActivity(), 71);
            }
        });
    }

    void loadDataToSpinner() {
        db.child(Category.EntityName.TABLE_NAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<List<Category>> typeIndicator = new GenericTypeIndicator<List<Category>>() {
                };
                List<Category> categories = snapshot.getValue(typeIndicator);
                ArrayAdapter<Category> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, categories);
                view.spCategory().setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onClickBtnSave() {
        view.btnSave().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = view.getPassedData().getStringExtra(ListProductPresenter.INTENT_KEY_TO_CREATE_PRODUCT);
                Post post = extractDataPassedFromProductListActivity(data);
                if (post != null) {
                    String productName = view.edtProductName().getText().toString();
                    String price = view.edtProductPrice().getText().toString();
                    Category cate = (Category) view.spCategory().getSelectedItem();
                    String url = imp.upLoadImageToCloud(filePath, view.getContext());
                    User logined = Utils.getLoginedUser(view.getContext());
                    String createdDate = Utils.getSystemDate();
                    List<String> listImage = new ArrayList<>();
                    listImage.add(url);
                    DatabaseReference ref = db.child(Product.EntityName.TABLE_NAME);
                    DatabaseReference postRef = db.child(Post.EntityName.TABLE_NAME);
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Product product = new Product();
                            product.setSupplierId(logined.getId());
                            product.setProductName(productName);
                            product.setPrice(Double.parseDouble(price));
                            product.setCategory(cate.getId());
                            product.setDateUpdated(createdDate);
                            product.setDateCreated(createdDate);
                            product.setProductImage(listImage);
                            product.setId(snapshot.getChildrenCount());
                            //ref.child(product.getId() + "").setValue(product);
                            snapshot.child(product.getId() + "").getRef().setValue(product);
                            DatabaseReference postDetailRef = postRef.child(post.getPostId() + "").child(Post.EntityName.DETAILS);
                            postDetailRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    PostDetail newDetail = new PostDetail();
                                    newDetail.setProductId(product.getId());
                                    newDetail.setStatus(true);
                                    newDetail.setId(snapshot.getChildrenCount());
                                    snapshot.child(newDetail.getId() + "").getRef().setValue(newDetail);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    view.edtProductName().setText("");
                    view.edtProductPrice().setText("");
                    view.imgViewProduct().setImageDrawable(null);
                    Toast.makeText(view.getContext(), "Add Successful !", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    @Override
    public void onClickBtnCancel() {

    }

    @Override
    public void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 71 && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(view.getContext().getContentResolver(), filePath);
                view.imgViewProduct().setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Post extractDataPassedFromProductListActivity(String data) {
        Post post = null;
        try {
            Gson gson = new Gson();
            post = gson.fromJson(data, Post.class);
        } catch (Exception e) {
            Toast.makeText(view.getContext(), "Opps!!! Something went wrong", Toast.LENGTH_LONG).show();
        }
        return post;
    }
}
