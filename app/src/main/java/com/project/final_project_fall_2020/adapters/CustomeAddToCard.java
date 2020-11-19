package com.project.final_project_fall_2020.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.R;

import java.util.List;

public class CustomeAddToCard extends BaseAdapter {
    private Activity activity;
    private int layout;
    private List<Order> list;

    public CustomeAddToCard() {
    }

    public CustomeAddToCard(Activity activity, int layout, List<Order> list) {
        this.activity = activity;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txtName;
        TextView txtQuantity;
        TextView txtPrice;
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(layout, null);
            txtName = convertView.findViewById(R.id.txtNameAddToCart);
            txtQuantity = convertView.findViewById(R.id.txtQuantityAddToCart);
            txtPrice = convertView.findViewById(R.id.txtPriceAddToCart);
            convertView.setTag(R.id.txtNameAddToCart, txtName);
            convertView.setTag(R.id.txtQuantityAddToCart, txtQuantity);
            convertView.setTag(R.id.txtPriceAddToCart, txtPrice);
        }else{
            txtName = (TextView) convertView.getTag(R.id.txtNameAddToCart);
            txtQuantity = (TextView) convertView.getTag(R.id.txtQuantityAddToCart);
            txtPrice = (TextView) convertView.getTag(R.id.txtPriceAddToCart);
        }
        Order order = list.get(position);
        txtName.setText(order.getDetails().get(position).getProductId()+"");
        txtQuantity.setText(order.getDetails().get(position).getQuantity()+"");
        txtPrice.setText(order.getDetails().get(position).getTotalAmount()+"");
        return convertView;
    }
}
