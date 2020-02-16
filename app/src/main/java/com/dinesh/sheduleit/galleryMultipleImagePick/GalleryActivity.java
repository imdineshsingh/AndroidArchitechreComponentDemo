package com.dinesh.sheduleit.galleryMultipleImagePick;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dinesh.sheduleit.MainActivity;
import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityGalleryBinding;

import java.io.File;
import java.util.List;

public class GalleryActivity extends AppCompatActivity implements BSImagePicker.OnSingleImageSelectedListener,
        BSImagePicker.OnMultiImageSelectedListener, BSImagePicker.ImageLoaderDelegate, BSImagePicker.OnSelectImageCancelledListener{

    private Context context;
    private ActivityGalleryBinding binding;
    /*private static final int REQUEST_GET_SINGLE_FILE = 111;
    private static final int GALLERY_PERMISSION_REQUST = 100;
    private String[] permissons= new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_gallery);
        context=GalleryActivity.this;

    //    intiMyProgram();

        init();

    }

    private void init() {
        binding.tvSingleSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BSImagePicker pickerDialog = new BSImagePicker.Builder("com.dinesh.sheduleit.imagepickersheetdemo.fileprovider")
                        .build();
                pickerDialog.show(getSupportFragmentManager(), "picker");
            }
        });

        binding.tvMultiSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BSImagePicker pickerDialog = new BSImagePicker.Builder("com.dinesh.sheduleit.imagepickersheetdemo.fileprovider")
                        .setMaximumDisplayingImages(Integer.MAX_VALUE)
                        .isMultiSelect()
                        .setMinimumMultiSelectCount(1)
                        .setMaximumMultiSelectCount(5)
                        .build();
                pickerDialog.show(getSupportFragmentManager(), "picker");

            }
        });


    }

    @Override
    public void onSingleImageSelected(Uri uri, String tag) {
        Glide.with(this).load(uri).into(binding.ivImage2);

    }

    @Override
    public void onMultiImageSelected(List<Uri> uriList, String tag) {
        for (int i=0; i < uriList.size(); i++) {
            if (i >= 6) return;
            ImageView iv;
            switch (i) {
                case 0:
                    iv = binding.ivImage1;
                    break;
                case 1:
                    iv = binding.ivImage2;
                    break;
                case 2:
                    iv = binding.ivImage3;
                    break;
                case 3:
                    iv = binding.ivImage4;
                    break;
                case 4:
                    iv = binding.ivImage5;
                    break;
                case 5:
                default:
                    iv = binding.ivImage6;
            }
            Glide.with(this).load(uriList.get(i)).into(iv);
        }

    }

    @Override
    public void loadImage(Uri imageUri, ImageView ivImage) {
        Glide.with(this).load(imageUri).into(ivImage);

    }

    @Override
    public void onCancelled(boolean isMultiSelecting, String tag) {
        Toast.makeText(this, "Selection is cancelled, Multi-selection is " + isMultiSelecting, Toast.LENGTH_SHORT).show();

    }












    /*

    private void intiMyProgram() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(String.valueOf(permissons))== PackageManager.PERMISSION_GRANTED){
                return;
            }else {
                requestPermissions(permissons,GALLERY_PERMISSION_REQUST);
            }
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==GALLERY_PERMISSION_REQUST ){
            if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                galleryIntent();
            }else {
                Toast.makeText(context, "please accept permission first", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void galleryIntent(){
        Intent intent = new Intent();

        intent.setAction(Intent.ACTION_GET_CONTENT);
        //intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"),REQUEST_GET_SINGLE_FILE);

    }

    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if (resultCode == RESULT_OK) {
                if (requestCode == REQUEST_GET_SINGLE_FILE) {
                    Uri selectedImageUri = data.getData();
                    // Get the path from the Uri
                    final String path = getPathFromURI(selectedImageUri);
                    if (path != null) {
                        File f = new File(path);
                        selectedImageUri = Uri.fromFile(f);
                    }
                    // Set the image in ImageView
                    binding.imageView.setImageURI(selectedImageUri);
                }
            }
        } catch (Exception e) {
            Log.e("FileSelectorActivity", "File select error", e);
        }

    }*/
}
