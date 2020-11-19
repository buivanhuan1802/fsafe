package com.project.final_project_fall_2020.adapters;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomProductAdapter extends BaseAdapter {
    private int layout;
    private Activity activity;
    private List<Product> products;

    public CustomProductAdapter(Activity activity, int layout, List<Product> products) {
        this.layout = layout;
        this.activity = activity;
        this.products = products;

    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView productName;
        TextView price;
        TextView dateCreated;
        ImageView imageView;
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(layout, null);
            productName = convertView.findViewById(R.id.productName);
            price = convertView.findViewById(R.id.productPrice);
            dateCreated = convertView.findViewById(R.id.dateCreated);
            imageView = convertView.findViewById(R.id.bannerUrl);
            convertView.setTag(R.id.productName, productName);
            convertView.setTag(R.id.productPrice, price);
            convertView.setTag(R.id.dateCreated, dateCreated);
            convertView.setTag(R.id.bannerUrl, imageView);

        } else {
            productName = (TextView) convertView.getTag(R.id.productName);
            price = (TextView) convertView.getTag(R.id.productPrice);
            dateCreated = (TextView) convertView.getTag(R.id.dateCreated);
            imageView = (ImageView) convertView.getTag(R.id.bannerUrl);
        }
        Product selected = products.get(position);
        productName.setText(selected.getProductName());
        price.setText(selected.getPrice() + "");
        dateCreated.setText(selected.getDateCreated());
        StorageReference srf = FirebaseStorage.getInstance().getReference(selected.getProductImage().get(0));
        srf.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(imageView);
            }
        });
        return convertView;
    }
}
