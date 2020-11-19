package com.project.final_project_fall_2020.adapters;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Post;
import com.squareup.picasso.Picasso;

public class CustomPostAdapter extends BaseAdapter {
    private int layout;
    private Activity activity;
    private List<Post> posts;

    public CustomPostAdapter(Activity activity, int layout, List<Post> posts) {
        this.layout = layout;
        this.activity = activity;
        this.posts = posts;

    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView postTitle;
        TextView openTime;
        ImageView imageView;
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(layout, null);
            postTitle = convertView.findViewById(R.id.productName);
            openTime = convertView.findViewById(R.id.postOpeningTime);
            imageView = convertView.findViewById(R.id.bannerUrl);
            convertView.setTag(R.id.productName, postTitle);
            convertView.setTag(R.id.postOpeningTime, openTime);
            convertView.setTag(R.id.bannerUrl, imageView);

        } else {
            postTitle = (TextView) convertView.getTag(R.id.productName);
            openTime = (TextView) convertView.getTag(R.id.postOpeningTime);
            imageView = (ImageView) convertView.getTag(R.id.bannerUrl);
        }
        Post post = posts.get(position);
        postTitle.setText(post.getPostTitle());
        openTime.setText("Opening: " + post.getStartTime() + " - " + post.getEndTime());
        StorageReference srf = FirebaseStorage.getInstance().getReference(post.getBannerurl());
        srf.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(imageView);
            }
        });
        return convertView;
    }
}
