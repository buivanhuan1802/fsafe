package com.project.final_project_fall_2020.view.supplier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.utils.CommonConstant;

import java.util.ArrayList;
import java.util.List;

public class SupplierHomeActivity extends AppCompatActivity {
    private Spinner spDashBoard;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_home);
        List<String> a = new ArrayList<>();
        frameLayout = findViewById(R.id.frameLayout);
        a.add("New Order");
        a.add("Post");
        a.add("FeedBack");
        a.add("Business Analysis");
        spDashBoard = findViewById(R.id.spDashBoard);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.custom_spinner_text, a);
        spDashBoard.setAdapter(adapter);

        spDashBoard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment fag;
                String tag;
                if (position == 0) {
                    fag = new SupplierNewOrder();
                    tag = CommonConstant.NEW_ORDER_FAGMENT_TAG;
                } else {
                    tag = CommonConstant.POST_MANAGEMENT_FAGMENT_TAG;
                    fag = new PostManagerFagement();
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FragmentManager fm = getSupportFragmentManager();
                try {
                    Fragment currentFagment = fm.findFragmentByTag(CommonConstant.CURRENT_FAGMENT);
                    transaction.remove(currentFagment);
                    transaction.add(R.id.frameLayout, fag, tag);
                    transaction.commit();
                    CommonConstant.CURRENT_FAGMENT = tag;
                } catch (Exception e) {
                    transaction.add(R.id.frameLayout, new SupplierNewOrder(), CommonConstant.NEW_ORDER_FAGMENT_TAG);
                    transaction.commit();
                    CommonConstant.CURRENT_FAGMENT = CommonConstant.NEW_ORDER_FAGMENT_TAG;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}