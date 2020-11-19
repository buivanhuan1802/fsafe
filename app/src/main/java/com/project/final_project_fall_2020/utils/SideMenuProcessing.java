package com.project.final_project_fall_2020.utils;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.view.StartActivity;
import com.project.final_project_fall_2020.view.customer.FastFoodAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.MainActivityForCustomer;
import com.project.final_project_fall_2020.view.customer.OfficeMealAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ProfileAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ServiceAsCustomerActivity;
import com.project.final_project_fall_2020.view.supplier.BusinessAnalysisActivity;
import com.project.final_project_fall_2020.view.supplier.FeedbackManagementActivity;
import com.project.final_project_fall_2020.view.supplier.OrderManagementActivity;
import com.project.final_project_fall_2020.view.supplier.PostManagementActivity;
import com.project.final_project_fall_2020.view.supplier.SupplierCreatePostActivity;
import com.project.final_project_fall_2020.view.supplier.SupplierHomeActivity;

public class SideMenuProcessing {


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem, Context from, DrawerLayout drawerLayout, String role) {
        if (role.equals("2")) {
            Intent intent = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_order:
                    intent = new Intent(from, OrderManagementActivity.class);
                    break;
                case R.id.nav_post:
                    intent = new Intent(from, PostManagementActivity.class);
                    break;
                case R.id.nav_feedback:
                    intent = new Intent(from, FeedbackManagementActivity.class);
                    break;
                case R.id.nav_ba:
                    intent = new Intent(from, BusinessAnalysisActivity.class);
                    break;
                case R.id.nav_profile:
                    // intent = new Intent(from, BusinessAnalysisActivity.class);
                    break;
                case R.id.nav_logout:
                      intent = new Intent(from, StartActivity.class);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
            }
            from.startActivity(intent);
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else {
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    break;
                case R.id.nav_fastFood:
                    Intent intent = new Intent(from, FastFoodAsCustomerActivity.class);
                    from.startActivity(intent);
                    break;
                case R.id.nav_officeMeal:
                    Intent intent1 = new Intent(from, OfficeMealAsCustomerActivity.class);
                    from.startActivity(intent1);
                    break;
                case R.id.nav_service:
                    Intent intent2 = new Intent(from, ServiceAsCustomerActivity.class);
                    from.startActivity(intent2);
                    break;
                case R.id.nav_profile:
                    Intent intent3 = new Intent(from, ProfileAsCustomerActivity.class);
                    from.startActivity(intent3);
                    break;
                case R.id.nav_logout:
                    Intent intent4 = new Intent(from, StartActivity.class);
                    GoogleSignInOptions gso = new GoogleSignInOptions.
                            Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                            build();
                    GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(from.getApplicationContext(), gso);

                    googleSignInClient.signOut();
                    from.startActivity(intent4);
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    }
}
