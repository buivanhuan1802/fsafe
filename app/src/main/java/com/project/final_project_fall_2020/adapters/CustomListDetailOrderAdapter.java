package com.project.final_project_fall_2020.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.OrderDetail;
import com.project.final_project_fall_2020.model.Product;
import com.project.final_project_fall_2020.model.User;

import java.util.List;

public class CustomListDetailOrderAdapter extends BaseAdapter {
    private int layout;
    private Activity activity;
    private List<OrderDetail> details;

    public CustomListDetailOrderAdapter(Activity activity, int layout, List<OrderDetail> details) {
        this.activity = activity;
        this.layout = layout;
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Object getItem(int position) {
        return details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return details.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView detailProductName;
        TextView detailQuantity;
        TextView detailPrice;
        TextView detailAmount;
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(layout, null);
            detailProductName = convertView.findViewById(R.id.edtDetailPName);
            detailQuantity = convertView.findViewById(R.id.edtDetailQuantity);
            detailPrice = convertView.findViewById(R.id.edtDetailPrice);
            detailAmount = convertView.findViewById(R.id.edtDetailAmount);
            convertView.setTag(R.id.edtDetailPName, detailProductName);
            convertView.setTag(R.id.edtDetailQuantity, detailQuantity);
            convertView.setTag(R.id.edtDetailPrice, detailPrice);
            convertView.setTag(R.id.edtDetailAmount, detailAmount);
        } else {
            detailProductName = (TextView) convertView.getTag(R.id.edtDetailPName);
            detailQuantity = (TextView) convertView.getTag(R.id.edtDetailQuantity);
            detailPrice = (TextView) convertView.getTag(R.id.edtDetailPrice);
            detailAmount = (TextView) convertView.getTag(R.id.edtDetailAmount);
        }
        OrderDetail selected = details.get(position);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(Product.EntityName.TABLE_NAME).child(selected.getProductId() + "");
        ref.keepSynced(true);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<Product> typeIndicator = new GenericTypeIndicator<Product>() {
                };
                Product product = snapshot.getValue(typeIndicator);
                detailProductName.setText(product.getProductName());
                detailQuantity.setText(selected.getQuantity() + "");
                detailPrice.setText(product.getPrice() + "");
                detailAmount.setText((selected.getQuantity() * product.getPrice()) + "");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return convertView;
    }
}
