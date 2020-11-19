package com.project.final_project_fall_2020.presenter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.project.final_project_fall_2020.model.AppRole;
import com.project.final_project_fall_2020.model.Category;
import com.project.final_project_fall_2020.model.Order;
import com.project.final_project_fall_2020.model.Post;
import com.project.final_project_fall_2020.model.PostDetail;
import com.project.final_project_fall_2020.model.Product;
import com.project.final_project_fall_2020.model.User;
import com.project.final_project_fall_2020.utils.CommonConstant;
import com.project.final_project_fall_2020.utils.ImageProcessing;
import com.project.final_project_fall_2020.utils.Utils;
import com.project.final_project_fall_2020.view.supplier.SupplierEditProductActivity;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import okhttp3.internal.Util;

public class SupplierEditProductPresenter implements SupplierEditProductActivityContract.Presenter {
    private SupplierEditProductActivityContract.View view;
    private DatabaseReference db;
    private StorageReference srf;
    private final int PICK_IMAGE_REQUEST = 71;
    private Uri filePath;
    private ImageProcessing imp;

    public SupplierEditProductPresenter(SupplierEditProductActivityContract.View view) {
        this.view = view;
        db = FirebaseDatabase.getInstance().getReference();
        imp = new ImageProcessing();
        intiComponent();
    }

    void intiComponent() {
        loadStartData();
        setOncheckedChangeRdioGroup();
        setOnclickBtnDelete();
        setOnclickProductUImageView();
        setOnlickBtnSave();
    }

    @Override
    public void chooseImage() {

    }

    @Override
    public void onActivityForResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(view.getConext().getContentResolver(), filePath);
                view.getProductImageView().setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String uploadImage() {
        return ""
                ;
    }

    @Override
    public void setOnlickBtnSave() {
        view.getBtnSave().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Gson gson = new Gson();
                    String productName = view.getEdtProductName().getText().toString();
                    String price = view.getEdtPrice().getText().toString();
                    String object = view.getPassedData().getStringExtra(ListProductPresenter.INTENT_KEY_TO_EDIT_PRODUCT);
                    String url = imp.upLoadImageToCloud(filePath, view.getConext());
                    DatabaseReference ref = db.child(Product.EntityName.TABLE_NAME);
                    if (object != null && !object.equals("")) {
                        Product current = gson.fromJson(object, Product.class);
                        if (!url.equals("")) {
                            List<String> listNewImageUrl = new ArrayList<>();
                            listNewImageUrl.add(url);
                            current.setProductImage(listNewImageUrl);
                        }
                        current.setProductName(productName);
                        current.setPrice(Double.parseDouble(price));
                        String updatedDate = Utils.getSystemDate();
                        Category cate = (Category) view.spCategory().getSelectedItem();
                        current.setDateUpdated(updatedDate);
                        current.setCategory(cate.getId());
                        ref.child(current.getId() + "").setValue(current);
                        Toast.makeText(view.getConext(), "Save Successful !", Toast.LENGTH_LONG).show();

                    }
                    view.getEdtProductName().setText("");
                    view.getEdtPrice().setText("");
                    view.getProductImageView().setImageDrawable(null);
                } catch (Exception e) {
                    Toast.makeText(view.getConext(), "Opps! something went wrong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void setOnclickBtnDelete() {

    }

    @Override
    public void setOnclickProductUImageView() {
        view.getProductImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imp.chooseImage(view.getActivity(), PICK_IMAGE_REQUEST);
            }
        });
    }

    @Override
    public void setOncheckedChangeRdioGroup() {

    }

    @Override
    public void loadStartData() {
        String data = view.getPassedData().getStringExtra(ListProductPresenter.INTENT_KEY_TO_EDIT_PRODUCT);
        if (data == null || data.equals("")) {
            db.child(Category.EntityName.TABLE_NAME).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    GenericTypeIndicator<List<Category>> typeIndicator = new GenericTypeIndicator<List<Category>>() {
                    };
                    List<Category> categories = snapshot.getValue(typeIndicator);
                    ArrayAdapter<Category> adapter = new ArrayAdapter<>(view.getConext(), android.R.layout.simple_list_item_1, categories);
                    view.spCategory().setAdapter(adapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            return;
        }

        Product product = extractDataPassedFromProductListActivity(data);
        view.getEdtProductName().setText(product.getProductName());
        view.getEdtPrice().setText(product.getPrice() + "");
        db.child(Category.EntityName.TABLE_NAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<List<Category>> typeIndicator = new GenericTypeIndicator<List<Category>>() {
                };
                List<Category> categories = snapshot.getValue(typeIndicator);
                ArrayAdapter<Category> adapter = new ArrayAdapter<>(view.getConext(), android.R.layout.simple_list_item_1, categories);
                view.spCategory().setAdapter(adapter);
                view.spCategory().setSelection(Integer.parseInt(product.getCategory()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        srf = FirebaseStorage.getInstance().getReference(product.getProductImage().get(0));
        srf.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(view.getProductImageView());
            }
        });
    }

    @Override
    public Product extractDataPassedFromProductListActivity(String data) {
        Product product = null;
        try {
            Gson gson = new Gson();
            product = gson.fromJson(data, Product.class);
        } catch (Exception e) {
            Toast.makeText(view.getConext(), "Opps!!! Something went wrong", Toast.LENGTH_LONG).show();
        }
        return product;
    }


}
