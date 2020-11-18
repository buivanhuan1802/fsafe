package com.project.final_project_fall_2020.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.List;

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
            postTitle = convertView.findViewById(R.id.postTitle);
            openTime = convertView.findViewById(R.id.openingTime);
            imageView = convertView.findViewById(R.id.productImage);
            convertView.setTag(R.id.postTitle, postTitle);
            convertView.setTag(R.id.openingTime, openTime);
            convertView.setTag(R.id.productImage, imageView);

        } else {
            postTitle = (TextView) convertView.getTag(R.id.postTitle);
            openTime = (TextView) convertView.getTag(R.id.openingTime);
            imageView = (ImageView) convertView.getTag(R.id.productImage);
        }
        Post post = posts.get(position);
        postTitle.setText(post.getPostTitle());
        openTime.setText("Opening: " + post.getStartTime() + " - " + post.getEndTime());
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);
        return convertView;
    }
}
