package com.project.final_project_fall_2020.view.customer;

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
import com.project.final_project_fall_2020.model.User;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginAsCustomerActivity extends AppCompatActivity {

    private SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN = 100;
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
        mAuth = FirebaseAuth.getInstance();
        //Configure Google sign in
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        //Build a GoogleSignInClient with the options specified by gso
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton = findViewById(R.id.signInButton);
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
            Toast.makeText(LoginAsCustomerActivity.this, "Signed in Successfull", Toast.LENGTH_SHORT).show();
            firebaseAuthWithGoogle(acc);
            Intent intent = new Intent(LoginAsCustomerActivity.this, MainActivityForCustomer.class);
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
            User user =new User(account.getDisplayName(), account.getEmail());
            intent.putExtra("user", user);
            startActivityForResult(intent, RC_SIGN_IN);
        }catch ( ApiException e){
            Toast.makeText(LoginAsCustomerActivity.this, "Signed in falied", Toast.LENGTH_SHORT).show();
            firebaseAuthWithGoogle(null);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(LoginAsCustomerActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                    FirebaseUser user1= mAuth.getCurrentUser();
                    updateUI(user1);
                } else {
                    Toast.makeText(LoginAsCustomerActivity.this, "Sorry auth failed", Toast.LENGTH_SHORT).show();
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