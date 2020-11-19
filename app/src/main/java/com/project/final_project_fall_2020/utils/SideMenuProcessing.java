package com.project.final_project_fall_2020.utils;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.view.StartActivity;
import com.project.final_project_fall_2020.view.customer.FastFoodAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.OfficeMealAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ProfileAsCustomerActivity;
import com.project.final_project_fall_2020.view.customer.ServiceAsCustomerActivity;
import com.project.final_project_fall_2020.view.supplier.SupplierCreatePostActivity;

public class SideMenuProcessing {


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem, Context from, DrawerLayout drawerLayout) {
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
                from.startActivity(intent4);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
