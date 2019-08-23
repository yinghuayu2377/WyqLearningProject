package com.example.sd.learningproject.multimedia;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 拍照及选择图片
 */
public class CameraAndChoosePhotoActivity extends AppCompatActivity {

    @BindView(R.id.image_view)
    ImageView mImageView;

    private static final int TAKE_PHOTO = 1;
    private static final int CHOOSE_PHOTO = 2;
    private Uri mImageUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_and_choose_photo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:  // 拍照,这里使用ContentProvider来获取图片
                File outputImage = new File(getExternalCacheDir(), "output_iamge.jpg");  // 放入此目录不需要读写SD卡的权限
                try {
                    if (outputImage.exists()) {
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    mImageUri = FileProvider.getUriForFile(CameraAndChoosePhotoActivity.this,
                            "com.example.sd.learningproject.fileprovider", outputImage);
                } else {
                    mImageUri = Uri.fromFile(outputImage);
                }
                // 启动相机
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  // 前边需要进行权限验证
                intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
                startActivityForResult(intent, TAKE_PHOTO);
                break;

            case R.id.button2:  // 需要先进行权限判断，不使用ContentProvider来获取图片
                Intent intent1 = new Intent(Intent.ACTION_GET_CONTENT);
                intent1.setType("image/*");
                startActivityForResult(intent1, CHOOSE_PHOTO);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TAKE_PHOTO:
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(mImageUri));
                        mImageView.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case CHOOSE_PHOTO:
                    if (data != null) {
                        handleImageBeforeKitkat(data);
                    }
                    break;
            }
        }
    }

    private void handleImageBeforeKitkat(Intent intent) {
        String imagePath = intent.getDataString();
        Uri uri = intent.getData();
        if (imagePath != null) {
            displayImage(uri);
        }
    }

    private void displayImage(Uri uri) {
        if (uri != null) {
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                mImageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }
}
