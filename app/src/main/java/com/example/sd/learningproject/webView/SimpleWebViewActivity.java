package com.example.sd.learningproject.webView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.*;
import android.widget.Button;
import android.widget.Toast;
import com.example.sd.learningproject.R;

public class SimpleWebViewActivity extends AppCompatActivity {

    private WebView mSimpleWebView = null;
    private Button mCallJsButton = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_webview);

        mSimpleWebView = (WebView) findViewById(R.id.simple_webview);
        mCallJsButton = (Button) findViewById(R.id.button_java_call_js);
        showSimpleWebView();
    }

    @SuppressLint({"SetJavaScriptEnabled","JavascriptInterface","addJavascriptInterface"})
    private void showSimpleWebView() {
        WebSettings webSettings = mSimpleWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);  // 设置与js交互的权限
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);  // 设置允许JS弹窗

        //JsInterface为管理native与js交互的类，bridge为js调用native时的别名
        mSimpleWebView.addJavascriptInterface(new JsInterface(), "bridge");
        mSimpleWebView.loadUrl("file:///android_asset/test1.html");  // 载入js代码

        callJs();

        mSimpleWebView.setWebChromeClient(new WebChromeClient() {
            // 响应js的Alert函数
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(SimpleWebViewActivity.this);
                dialog.setTitle("Alert");
                dialog.setMessage(message);
                dialog.create().show();
                result.cancel();  // 一定要调用cancel()或confirm()，不然onJsAlert只会调用一次
                return true;
            }
        });
    }

    /**
     * js调用java
     */
    public class JsInterface {
        @JavascriptInterface  // 必须使用此注解
        public void helloNative(String str) { // 定义js需要调用的方法
            Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * java调用js
     */
    public void callJs() {
        mCallJsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String result = "传递的参数，";
                final String parameter = "'传递的参数，'";

                mSimpleWebView.post(new Runnable() {  // 必须在UI线程执行
                    @Override
                    public void run() {
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                            mSimpleWebView.loadUrl("javascript:callJs(" + parameter + ")");  // 4.4以下版本使用loadUrl
                        } else {
                            // 4.4及以上版本使用evaluateJavascript
                            mSimpleWebView.evaluateJavascript(String.format(getString(R.string.java_call_js), result),  // 两种string写法均可
                                    new ValueCallback<String>() {
                                @Override
                                public void onReceiveValue(String value) {
                                    // js返回的结果
                                }
                            });
                        }
                    }
                });
            }
        });
    }
}
