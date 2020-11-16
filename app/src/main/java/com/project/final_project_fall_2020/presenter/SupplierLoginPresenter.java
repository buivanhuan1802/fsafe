package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.JsonReader;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.AppRole;
import com.project.final_project_fall_2020.model.User;
import com.project.final_project_fall_2020.utils.CommonConstant;
import com.project.final_project_fall_2020.view.supplier.SupplierHomeActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.util.List;

public class SupplierLoginPresenter implements SupplierActivityContract.Presenter {
    SupplierActivityContract.View view;
    private DatabaseReference db;

    public SupplierLoginPresenter(SupplierActivityContract.View view) {
        this.view = view;
        try {
            view.initComponents();
            btnLoginAction();
            if (isNetWorkAvailable()) {
                db = FirebaseDatabase.getInstance().getReference();
                btnLoginAction();
            } else {
                Toast.makeText(view.getContext(), "You are offline now.\nPlease check your connection", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(view.getContext(), view.getResource().getString(R.string.systemError), Toast.LENGTH_LONG).show();
        }
    }

    public boolean isNetWorkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) view.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void btnLoginAction() {
        if (view != null) {
            view.getBtnLogin().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String userName = view.getTextViewUserName().getText().toString();
                    final String password = view.getTextViewPassword().getText().toString();
                    if (userName.isEmpty() || password.isEmpty()) {
                        Toast.makeText(view.getContext(), "Please Enter username or password", Toast.LENGTH_LONG).show();
                    } else {
                        final Query query = db.child(User.EntityName.TABLE_NAME).orderByChild(User.EntityName.USER_NAME).equalTo(userName);

                        query.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                GenericTypeIndicator<List<User>> typeIndicator = new GenericTypeIndicator<List<User>>() {
                                };
                                List<User> user = snapshot.getValue(typeIndicator);
                                if (user == null || user.isEmpty()) {
                                    Toast.makeText(view.getContext(), getLoginErrorMessage(), Toast.LENGTH_LONG).show();
                                } else {
                                    String roleString = snapshot.child(user.get(0).getId() + "/" + User.EntityName.APP_ROLE).getValue().toString();
                                    Gson gson = new Gson();
                                    AppRole role = gson.fromJson(roleString, AppRole.class);
                                    User state = user.get(0);
                                    if (state.getPassword().equals(password) && (int) role.getId() == 2) {
                                        Intent intent = new Intent(view.getContext(), SupplierHomeActivity.class);
                                        SharedPreferences pref = view.getSharedPreferences(CommonConstant.PREFERENCE_LOGINED, Context.MODE_PRIVATE);
                                        saveUserToPref(pref, user.get(0));
                                        view.startActivity(intent);
                                    } else {
                                        Toast.makeText(view.getContext(), getLoginErrorMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }

                }
            });
        }

    }

    @Override
    public void saveUserToPref(SharedPreferences pref, User data) {
        Gson gson = new Gson();
        String json = gson.toJson(data);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(CommonConstant.PREFERENCE_LOGINED, json);
        editor.commit();

    }

    @Override
    public String getLoginErrorMessage() {
        return view.getResource().getString(R.string.loginError);
    }
}
