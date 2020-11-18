package com.project.final_project_fall_2020.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Order;

import java.util.List;

public class CustomOrderAdapter extends BaseAdapter {
    private Activity activity;
    private int layout;
    private List<Order> list;

    public CustomOrderAdapter(Activity activity, int layout, List<Order> orders) {
        this.activity = activity;
        this.layout = layout;
        this.list = orders;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView orderId;
        TextView orderDate;
        TextView totalAmount;
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(layout, null);
            orderId = convertView.findViewById(R.id.customOrderIdListView);
            orderDate = convertView.findViewById(R.id.customOrderDateListView);
            totalAmount = convertView.findViewById(R.id.customTotalAmountListView);
            convertView.setTag(R.id.customOrderIdListView, orderId);
            convertView.setTag(R.id.customOrderDateListView, orderDate);
            convertView.setTag(R.id.customTotalAmountListView, totalAmount);
        } else {
            orderId = (TextView) convertView.getTag(R.id.customOrderIdListView);
            orderDate = (TextView) convertView.getTag(R.id.customOrderDateListView);
            totalAmount = (TextView) convertView.getTag(R.id.customTotalAmountListView);
        }
        Order order = list.get(position);
        orderId.setText("" + order.getId());
        orderDate.setText("date: " + order.getDateCreated());
        totalAmount.setText("total: " + order.getTotalAmount() + "vnd");
        if (position % 2 == 1) {
            convertView.setBackgroundColor(Color.rgb(237, 237, 237));
        }
        Toast.makeText(convertView.getContext(), order.getDateCreated(), Toast.LENGTH_LONG);
        return convertView;
    }
}
