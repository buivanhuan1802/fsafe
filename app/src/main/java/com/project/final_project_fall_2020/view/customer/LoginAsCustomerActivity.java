package com.project.final_project_fall_2020.view.customer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.AppRole;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.User;
import com.project.final_project_fall_2020.utils.CommonConstant;
import com.project.final_project_fall_2020.utils.Utils;

import java.util.List;

public class LoginAsCustomerActivity extends AppCompatActivity {

    private SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 2;
    private FirebaseAuth mAuth;
    private DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_customer);
        signInButton = findViewById(R.id.signInButton);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance().getReference();
        db.keepSynced(true);
        //Configure Google sign in
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            if (task.isComplete()) {
                handleSigInResult(task);
            } else {
                Toast.makeText(LoginAsCustomerActivity.this, "Signed in Fail", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void handleSigInResult(Task<GoogleSignInAccount> completeTask) {
        try {
            GoogleSignInAccount acc = completeTask.getResult(ApiException.class);
            String mail = acc.getEmail();
            if (mail.endsWith("@fpt.edu.vn")) {
                DatabaseReference ref = db.child(User.EntityName.TABLE_NAME).getRef();
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        GenericTypeIndicator<User> typeIndicator = new GenericTypeIndicator<User>() {
                        };
                        boolean isExisted = false;
                        for (DataSnapshot sp : snapshot.getChildren()) {
                            User x = sp.getValue(typeIndicator);
                            if (x.getEmail().equals(acc.getEmail())) {
                                SharedPreferences pref = getSharedPreferences(CommonConstant.PREFERENCE_LOGINED, Context.MODE_PRIVATE);
                                Utils.saveUserToPref(pref, x);
                                isExisted = true;
                                break;
                            }
                        }
                        if (!isExisted) {
                            User newUser = new User();
                            newUser.setRole(new AppRole(1, "Customer"));
                            newUser.setFullName(acc.getDisplayName());
                            newUser.setActive(true);
                            newUser.setEmail(acc.getEmail());
                            newUser.setId(snapshot.getChildrenCount());
                            snapshot.child(newUser.getId() + "").getRef().setValue(newUser);
                            SharedPreferences pref = getSharedPreferences(CommonConstant.PREFERENCE_LOGINED, Context.MODE_PRIVATE);
                            Utils.saveUserToPref(pref, newUser);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                Intent intent = new Intent(LoginAsCustomerActivity.this, MainActivityForCustomer.class);
                startActivity(intent);
                Toast.makeText(LoginAsCustomerActivity.this, "Signed in Successfull", Toast.LENGTH_SHORT).show();
            } else {
                mGoogleSignInClient.signOut();
                Toast.makeText(getApplicationContext(), "Please sign with FPT mail (hint: abc@fpt.edu.vn)", Toast.LENGTH_LONG).show();
            }
        } catch (ApiException e) {
            Toast.makeText(LoginAsCustomerActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}