package com.example.sd.learningproject.webView.basewebview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * 继承WebView基类的子类
 */
public class TestWebViewActivity extends BaseWebViewActivity implements BaseWebViewActivity.OtherActionListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setOtherActionListener(this);
    }

    @Override
    String getCustomUserAgentString() {
        return "";
    }

    @Override
    Object getInterfaceObject() {
        return new JsInterface();
    }

    @Override
    String getInterfaceName() {
        return "bridge";
    }

    @Override
    String getUrl() {
        return "file:///android_asset/test1.html";
    }

    @Override
    public void otherAction(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * js调用java
     */
    public class JsInterface {
        @JavascriptInterface
        public void helloNative(String str) { // 定义js需要调用的方法
            Toast.makeText(TestWebViewActivity.this, str, Toast.LENGTH_LONG).show();
        }
    }
}
