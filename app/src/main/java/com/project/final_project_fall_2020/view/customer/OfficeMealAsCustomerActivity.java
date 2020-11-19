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
import com.project.final_project_fall_2020.adapters.CustomPostAdapter;
import com.project.final_project_fall_2020.model.Post;

import java.util.ArrayList;
import java.util.List;

public class OfficeMealAsCustomerActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_meal);
        listView = findViewById(R.id.listView);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(Post.EntityName.TABLE_NAME);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Post> typeIndicator = new GenericTypeIndicator<Post>() {
                };

                List<Post> posts = new ArrayList<>();
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    posts.add(x.getValue(typeIndicator));
                }

                CustomPostAdapter adapter = new CustomPostAdapter(OfficeMealAsCustomerActivity.this, R.layout.custom_listview_post, posts);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OfficeMealAsCustomerActivity.this, ListProductOfPost.class);
                Post selected = (Post) listView.getAdapter().getItem(position);
                Gson gson = new Gson();
                String data = gson.toJson(selected);
                intent.putExtra("key",data);
                startActivity(intent);
            }
        });
    }


}