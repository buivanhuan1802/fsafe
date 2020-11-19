package com.project.final_project_fall_2020.view.customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.OrderDetail;
import com.project.final_project_fall_2020.model.Product;
import com.project.final_project_fall_2020.utils.CommonConstant;

import java.util.HashMap;
import java.util.List;

public class AddToCardAsCustomerActivity extends AppCompatActivity {
    private TextView txtUserId;
    private ListView listView;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txtUserId = findViewById(R.id.txtUserId);
        listView = findViewById(R.id.listView);
        btnSubmit = findViewById(R.id.btnSubmit);
        long userId = 3;
        setContentView(R.layout.activity_add_to_card_as_customer);
        SharedPreferences sharedPreferences = getSharedPreferences(CommonConstant.PREFERENCE_ORDER + "" + userId, Context.MODE_PRIVATE);
        String data = sharedPreferences.getString("list", "");
        txtUserId.setText(userId + "");
        Gson gson = new Gson();
        Order order = gson.fromJson(data, Order.class);
        HashMap<Long, List<OrderDetail>> hashMap= new HashMap<>();
        for (OrderDetail x : order.getDetails()){
            if(hashMap.containsKey(x.))
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(Order.EntityName.TABLE_NAME);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        GenericTypeIndicator<Order> typeIndicator = new GenericTypeIndicator<Order>() {
                        };

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}