package com.project.final_project_fall_2020.view.customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
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
import com.project.final_project_fall_2020.presenter.SupplierCreatePostActivityContract;
import com.project.final_project_fall_2020.presenter.SupplierCreatePostPresenter;
import com.project.final_project_fall_2020.utils.SideMenuProcessing;

import java.util.ArrayList;
import java.util.List;

public class OfficeMealAsCustomerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listView;
    private SideMenuProcessing sideMenuProcessing;
    private TextView txtName;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_meal);
        listView = findViewById(R.id.listView);
        sideMenuProcessing = new SideMenuProcessing();
        String name = "Hoang Dinh Viet";
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        Menu menu = navigationView.getMenu();

        //Navigation drawer menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
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
                intent.putExtra("key", data);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return sideMenuProcessing.onNavigationItemSelected(item, this, drawerLayout, "2");
    }
}