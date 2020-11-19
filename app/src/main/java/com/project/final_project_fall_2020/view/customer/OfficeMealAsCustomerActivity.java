package com.project.final_project_fall_2020.view.customer;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.PostDetail;

import java.util.ArrayList;
import java.util.List;

public class OfficeMealAsCustomerActivity extends AppCompatActivity {
    private ListView listView;
    DatabaseReference ref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_meal);
//        ref  = FirebaseDatabase.getInstance().getReference();
//        listView = findViewById(R.id.listView);
//        List<Post> listPost = new ArrayList<>();
//        ArrayAdapter adapter = new ArrayAdapter<Post>(this, R.layout.activity_office_meal, listView);
//        listView.setAdapter(adapter);
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Post");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                listPost.clear();
//                for (DataSnapshot snapshot1 : snapshot.getChildren()){
//                    Post post = new Post();
//                    listPost.add(snapshot1.getValue());
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        })
    }

}