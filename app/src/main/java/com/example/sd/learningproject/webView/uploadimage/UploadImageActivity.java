package com.example.sd.learningproject.webView.uploadimage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.*;
import com.example.sd.learningproject.R;

import java.io.File;
import java.util.UUID;

public class UploadImageActivity extends AppCompatActivity {

    private WebView mWebView = null;
    private ValueCallback<Uri[]> mFilePathCallback = null;
    private int REQUEST_CODE_LOLIPOP = 1;  // 5.0以上版本
    private String mCameraPhotoPath = "";  // 拍照的图片路径

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base_webview);

        mWebView = (WebView) findViewById(R.id.base_web_view);
        showWebView();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void showWebView() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        mWebView.loadUrl("file:///android_asset/test2.html");
        showCustomWebChromeClient();
    }

    private void showCustomWebChromeClient() {
        mWebView.setWebChromeClient(new WebChromeClient() {

            // 5.0+
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                if (mFilePathCallback != null) {
                    mFilePathCallback.onReceiveValue(null);
                }
                mFilePathCallback = filePathCallback;

                Intent intent = gotoChooseFile();  // 选择文件及拍照
                startActivityForResult(intent, REQUEST_CODE_LOLIPOP);
                return true;
            }

            // 4.1+
            public void openFileChooser(ValueCallback<Uri> uploadFile, String acceptType, String capture) {

            }
        });
    }

    /**
     * 选择文件及拍照
     */
    private Intent gotoChooseFile() {
        String saveName = Environment.getExternalStorageDirectory().getPath() + "/" + Environment.DIRECTORY_DCIM + "/Camera/";

        /**
         * 打开相机intent
         */
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(this.getPackageManager()) != null) {
            File photoFile = null;
            photoFile = new File(saveName + randomFileName() + ".jpg");
            if (!photoFile.exists()) {
                mCameraPhotoPath = "file:" + photoFile.getAbsolutePath();
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));  // 把Uri赋值给takePictureIntent
            } else {
                takePictureIntent = null;
            }
        }

        Intent[] takeoutArray = null;
        if (takePictureIntent != null) {
            takeoutArray = new Intent[]{takePictureIntent};
        } else {
            takeoutArray = new Intent[0];
        }

        /**
         * 获取图片intent
         */
        Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
        contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
        contentSelectionIntent.setType("image/*");


        /**
         * 使用系统选择器
         */
        Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
        chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, takeoutArray);  // 额外的intent

        return chooserIntent;
    }

    /**
     * 随机产生文件名
     */
    private String randomFileName() {
        return UUID.randomUUID().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_LOLIPOP) {  // 选择文件返回 5.0+
            Uri[] results = null;
            if (resultCode == RESULT_OK) {
                if (data == null) {
                    if (mCameraPhotoPath != null) {
                        results = new Uri[]{Uri.parse(mCameraPhotoPath)};
                    }
                } else {
                    String dataString = data.getDataString();
                    if (dataString != null) {
                        results = new Uri[]{Uri.parse(dataString)};
                    }
                }
            }
            mFilePathCallback.onReceiveValue(results);  // 当获取要传图片的Uri，通过该方法回调通知
            mFilePathCallback = null;
        }
    }

    @Override
    protected void onDestroy() {
        mWebView.removeAllViews();
        mWebView.destroy();
        super.onDestroy();
    }
}
