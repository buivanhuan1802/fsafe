package com.project.final_project_fall_2020.presenter;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
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
import com.project.final_project_fall_2020.adapters.CustomProductAdapter;
import com.project.final_project_fall_2020.model.PostDetail;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.Product;
import com.project.final_project_fall_2020.view.supplier.SupplierEditProductActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListProductPresenter implements ListProductActivityContract.Presenter {
    private ListProductActivityContract.View view;
    private DatabaseReference db;
    public static final String INTENT_KEY_TO_EDIT_PRODUCT = "PRODUCT_TO_EDIT";

    public ListProductPresenter(ListProductActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        loadDataToListProduct();
        onclickListProductItem();
        onClickCreateProduct();
    }

    @Override
    public void loadDataToListProduct() {
        String data = view.getPassedIntent().getStringExtra(SupplierPostManagementPresenter.INTENT_KEY_TO_LIST_PRODUCT);
        if (data != null && !data.equals("")) {
            Post post = extractDataPassedFromPostActivity(data);
            db.child(Product.EntityName.TABLE_NAME).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    GenericTypeIndicator<List<Product>> typeIndicator = new GenericTypeIndicator<List<Product>>() {
                    };
                    List<Product> products = snapshot.getValue(typeIndicator);
                    if (products != null) {
                        if (products.size() > 0) {
                            List<Long> listProductIdInDetail = new ArrayList<>();
                            List<Product> filtered = new ArrayList<>();
                            for (PostDetail detail : post.getDetails()) {
                                listProductIdInDetail.add(detail.getProductId());
                            }
                            for (Product x : products) {
                                if (listProductIdInDetail.contains(x.getId())) {
                                    filtered.add(x);
                                }
                            }
                            if (filtered.size() >= 1) {
                                CustomProductAdapter adapter = new CustomProductAdapter(view.getActivity(), R.layout.custom_listview_product, filtered);
                                view.getListProduct().setAdapter(adapter);
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

    }

    @Override
    public void onclickListProductItem() {
        view.getListProduct().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Product product = (Product) view.getListProduct().getAdapter().getItem(position);
                Intent intent = new Intent(view.getContext(), SupplierEditProductActivity.class);
                Gson gson = new Gson();
                String data = gson.toJson(product);
                intent.putExtra(INTENT_KEY_TO_EDIT_PRODUCT, data);
                view.startActivity(intent);
            }
        });
    }

    @Override
    public Post extractDataPassedFromPostActivity(String data) {
        Post post = null;
        try {
            Gson gson = new Gson();
            post = gson.fromJson(data, Post.class);
        } catch (Exception e) {
            Toast.makeText(view.getContext(), "Opps!!! Something went wrong", Toast.LENGTH_LONG).show();
        }
        return post;
    }

    @Override
    public void onClickCreateProduct() {
        view.getCreateButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), SupplierEditProductActivity.class);
                view.startActivity(intent);
            }
        });
    }
}
