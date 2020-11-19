package com.project.final_project_fall_2020.view.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.adapters.CustomProductAdapter;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.PostDetail;
import com.project.final_project_fall_2020.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListProductOfPost extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product_of_post2);
        listView = findViewById(R.id.listView);
        Gson gson = new Gson();
        String data = getIntent().getStringExtra("key");
        Post post  = gson.fromJson(data, Post.class);
        List<Long> listProductId = new ArrayList<>();
        for (PostDetail ptd : post.getDetails()) {
            listProductId.add(ptd.getProductId());
        }
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(Product.EntityName.TABLE_NAME);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<Product> typeIndicator = new GenericTypeIndicator<Product>() {
                };
                List<Product> filtered = new ArrayList<>();
                for (DataSnapshot x : snapshot.getChildren()) {
                    Product prd = x.getValue(typeIndicator);
                    if (listProductId.contains(prd.getId())) {
                        filtered.add(prd);
                    }
                }
                CustomProductAdapter adapter = new CustomProductAdapter(ListProductOfPost.this,R.layout.custom_listview_product,filtered);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListProductOfPost.this, OfficeMealDetailAsCustomerActivity.class);
                Product selected = (Product) listView.getAdapter().getItem(position);
                Gson gson = new Gson();
                String data = gson.toJson(selected);
                intent.putExtra("key", data);
                startActivity(intent);
            }
        });
    }


}