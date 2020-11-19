package com.project.final_project_fall_2020.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

public interface CustomerHomeActivityContract {
    interface View {
        Context getContext();
        void startActivity(Intent intent);
        CardView getOfficeMealCard();
        CardView getFastFoodCard();
        CardView getOtherServiceCard();
        CardView getDrinkCard();
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
        DrawerLayout getDrawerLayout();
    }

    interface Presenter {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
        void cardOfficeMealOnclick();
        void cardFastFoodOnclick();
        void cardOtherServiceOnclick();
        void cardDrinkOnclick();
    }
}
