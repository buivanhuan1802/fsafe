package com.project.final_project_fall_2020.router;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.IntDef;

import com.project.final_project_fall_2020.view.StartActivity;
import com.project.final_project_fall_2020.view.supplier.SupplierHomeActivity;
import com.project.final_project_fall_2020.view.supplier.LoginActivity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AppRouter {
    public static final int START_ROUTER = 0;
    public static final int SUPPLIER_LOGIN_ROUTER = 1;
    public static final int SUPPLIER_HOME_ROUTER = 2;
    private int routerFilter;
    private Context context;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = {START_ROUTER, SUPPLIER_LOGIN_ROUTER, SUPPLIER_HOME_ROUTER})
    public @interface router {
    }

    public AppRouter(@router int routerFilter, Context context) {
        this.routerFilter = routerFilter;
        this.context = context;
    }


    public Intent getIntent() {
        Intent intent;
        switch (this.routerFilter) {
            case START_ROUTER:
                intent = new Intent(this.context, StartActivity.class);
                break;
            case SUPPLIER_LOGIN_ROUTER:
                intent = new Intent(this.context, LoginActivity.class);
                break;
            case SUPPLIER_HOME_ROUTER:
                intent = new Intent(this.context, SupplierHomeActivity.class);
                break;
            default:
                intent = null;
                break;
        }
        return intent;
    }
}
