package com.project.final_project_fall_2020.view.customer;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityForCustomer extends AppCompatActivity {

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_for_customer);

//        btnLogout = findViewById(R.id.btnLogout);
//        txtName= findViewById(R.id.txtName);
//        txtEmail = findViewById(R.id.txtEmail);
//
//        Intent intent = getIntent();
//        User user1 = (User) intent.getSerializableExtra("user");
//
//        txtName.setText(user1.getUserName());
//        txtEmail.setText(user1.getEmail());

//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent intent = new Intent(getApplicationContext(), LoginAsCustomerActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}