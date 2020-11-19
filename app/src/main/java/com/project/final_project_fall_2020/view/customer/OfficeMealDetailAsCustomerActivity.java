package com.project.final_project_fall_2020.view.customer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.gson.Gson;
import com.project.final_project_fall_2020.R;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.OrderDetail;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.Product;
import com.project.final_project_fall_2020.model.User;
import com.project.final_project_fall_2020.utils.CommonConstant;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class OfficeMealDetailAsCustomerActivity extends AppCompatActivity {
    public static HashMap<Long, List<OrderDetail>> orderList = new HashMap<>();
    private TextView txtNameRestaurant;
    private TextView txtAddressRestaurant;
    private TextView txtNameProduct;
    private TextView txtPrice;
    private ImageView image;
    private EditText editTxtQuantity;
    private Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_meal_detail_as_customer);
        txtNameRestaurant = findViewById(R.id.txtNameRestaurant);
        txtAddressRestaurant = findViewById(R.id.txtAddressRestaurant);
        txtNameProduct = findViewById(R.id.txtNameProduct);
        image = findViewById(R.id.image);
        editTxtQuantity = findViewById(R.id.editTxtQuantity);
        btnAddToCart = findViewById(R.id.btnAddToCard);
        txtPrice = findViewById(R.id.txtPrice);
        Gson gson = new Gson();
        String data = getIntent().getStringExtra("key");
        Product product = gson.fromJson(data, Product.class);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(Product.EntityName.TABLE_NAME);
        Product product1 = new Product();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<Product> typeIndicator = new GenericTypeIndicator<Product>() {
                };

                for (DataSnapshot x : snapshot.getChildren()) {
                    Product prd = x.getValue(typeIndicator);
                    if (product.getId() == (prd.getId())) {
                        product1.setId(prd.getId());
                        product1.setSupplierId(prd.getSupplierId());
                        product1.setCategory(prd.getCategory());
                        product1.setDateCreated(prd.getDateCreated());
                        product1.setDateUpdated(prd.getDateUpdated());
                        product1.setPrice(prd.getPrice());
                        product1.setProductImage(prd.getProductImage());
                        product1.setProductName(prd.getProductName());
                    }

                }
                txtNameProduct.setText(product1.getProductName());
                txtPrice.setText(product1.getPrice() + "");
//                StorageReference srf = FirebaseStorage.getInstance().getReference(product1.getProductImage()+"");
//                System.out.println(product1.getProductImage()+" vccc");
//                srf.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                    @Override
//                    public void onSuccess(Uri uri) {
//                        Picasso.get().load(uri).into(image);
//                    }
//                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child(User.EntityName.TABLE_NAME);
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<User> typeIndicatorUser = new GenericTypeIndicator<User>() {
                };
                User suppliers = null;
                for (DataSnapshot x : snapshot.getChildren()) {
                    User supplier1 = x.getValue(typeIndicatorUser);
                    if (product1.getSupplierId() == (supplier1.getId())) {
                        suppliers = new User(supplier1.getId(), supplier1.getUserName(), supplier1.getAddress(), supplier1.getPhoneNumber());
                    }
                }
                txtNameRestaurant.setText(suppliers.getUserName() + "");
                txtAddressRestaurant.setText(suppliers.getAddress() + "--" + suppliers.getPhoneNumber());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editTxtQuantity.getText().toString();
                if (TextUtils.isEmpty(value)) {
                    Toast.makeText(OfficeMealDetailAsCustomerActivity.this, "Hãy chọn số lượng ", Toast.LENGTH_SHORT).show();
                } else {
                    long quantity = Integer.parseInt(value.toString());
                    Toast.makeText(OfficeMealDetailAsCustomerActivity.this, "So lương " + value, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(OfficeMealDetailAsCustomerActivity.this, ListProductOfPost.class);
                }
                List<Long> orderId = new ArrayList<>();
                DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child(Order.EntityName.TABLE_NAME);
                reference2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        GenericTypeIndicator<Order> typeIndicatorUser = new GenericTypeIndicator<Order>() {
                        };
                        for (DataSnapshot x : snapshot.getChildren()) {

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                long id = 2020112011;
                String dateCreate ="2020-11-20";
                String status = "2";
                long supplierId = product1.getSupplierId();
                List<OrderDetail> orderDetailList = new ArrayList<>();
                long detailId = 0;
                long productId = product1.getId();
                long quantityDetail = 2;
                double totalAmountDetail = 2 *  product1.getPrice();
                long userId = 3;
                long totalAmount = 0;
                for (int i =0; i < orderDetailList.size(); i++){
                    totalAmount += orderDetailList.get(i).getTotalAmount();
                }
//                Order order = new Order();
//                order.setId(id);
//                order.setDateCreated(dateCreate);
//                order.setSupplierId(supplierId);
//                order.setDetails(orderDetailList);
//                order.setStatus(status);
//                order.setTotalAmount(totalAmount);
//                order.setUserId(userId);




                SharedPreferences sharedPreferences = getSharedPreferences(CommonConstant.PREFERENCE_ORDER +"" +userId, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson1 = new Gson();
                String data = gson1.toJson(orderList);
                editor.putString("list", data);
                editor.commit();
            }
        });
    }

}