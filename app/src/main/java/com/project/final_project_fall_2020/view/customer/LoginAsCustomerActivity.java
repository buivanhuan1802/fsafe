package com.project.final_project_fall_2020.view.customer;

import android.content.Intent;
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
import com.project.final_project_fall_2020.R;

public class LoginAsCustomerActivity extends AppCompatActivity {

    private SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 2;
    private FirebaseAuth mAuth;

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if (user != null) {
//            Intent intent = new Intent(getApplicationContext(), MainActivityForCustomer.class);
//            startActivity(intent);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_as_customer);
        signInButton = findViewById(R.id.signInButton);
        mAuth = FirebaseAuth.getInstance();

        //Configure Google sign in
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //Build a GoogleSignInClient with the options specified by gso
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
            handleSigInResult(task);
        }
    }

    private void handleSigInResult(Task<GoogleSignInAccount> completeTask) {
        try {
            GoogleSignInAccount acc = completeTask.getResult(ApiException.class);
            System.out.println("vao day1");
            Toast.makeText(LoginAsCustomerActivity.this, "Signed in Successfull", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
            Intent intent = new Intent(LoginAsCustomerActivity.this, MainActivityForCustomer.class);
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
//            User user = new User(account.getDisplayName(), account.getEmail());
//            intent.putExtra("user", user);
            startActivityForResult(intent, 100);

        } catch (ApiException e) {
            System.out.println("Hoang Dinh Viet" + e.getMessage());
            Toast.makeText(LoginAsCustomerActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            //FirebaseGoogleAuth(null);
        }
    }

    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginAsCustomerActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    Toast.makeText(LoginAsCustomerActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }


    private void updateUI(FirebaseUser user) {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null) {
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personID = account.getId();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(LoginAsCustomerActivity.this, personName + personEmail, Toast.LENGTH_SHORT).show();
        }
    }

}