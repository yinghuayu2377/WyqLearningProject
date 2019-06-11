package com.example.sd.learningproject.webView.basewebview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.*;
import com.example.sd.learningproject.R;

/**
 * WebView基类
 */
public abstract class BaseWebViewActivity extends AppCompatActivity {

    private WebView mWebView = null;
    private OtherActionListener mOtherActionListener = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_webview);

        mWebView = (WebView) findViewById(R.id.base_web_view);

        initWebSettings();
        mWebView.loadUrl(getUrl());  // 加载url
        mWebView.setWebChromeClient(getWebChromeClient());
        mWebView.setWebViewClient(getWebViewClient());
    }

    /**
     * 设置WebView属性
     */
    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface", "AddJavascriptInterface"})
    private void initWebSettings() {
        WebSettings webSettings = mWebView.getSettings();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW); // 允许加载混合网路协议内容
        }
        webSettings.setLoadWithOverviewMode(true);  // 适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setJavaScriptEnabled(true); // 允许使用javascript
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);  // 设置缓存模式
        webSettings.setDomStorageEnabled(true);  // 开启DOM缓存
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);  // 允许加载新窗口
        webSettings.setAllowFileAccess(true);  // 允许访问文件数据

        webSettings.setUserAgentString(webSettings.getUserAgentString() + getCustomUserAgentString());  // 设置user-agent

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            if (null != getInterfaceObject() && null != getInterfaceName())
                mWebView.addJavascriptInterface(getInterfaceObject(), getInterfaceName());
        }
    }

    /**
     * 额外添加的userAgent
     */
    abstract String getCustomUserAgentString();

    /**
     * 管理native与js交互代码的类
     */
    abstract Object getInterfaceObject();

    /**
     * js调用native时的别名
     */
    abstract String getInterfaceName();

    /**
     * 需加载的url
     */
    abstract String getUrl();

    /**
     * 重写WebChromeClient--处理js的对话框、图标、title、加载进度等
     */
    private WebChromeClient getWebChromeClient() {
        return new WebChromeClient() {
            @Override  // 接收文档标题
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override  // 显示Alert对话框
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override  // 显示confirm对话框
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override  // 显示prompt对话框
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }

            @Override  // 显示文件选择器
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
        };

    }

    /**
     * 重写WebViewClient--处理各种通知、请求事件
     */
    private WebViewClient getWebViewClient() {
        return new WebViewClient(){

            @Override  // url开始加载
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override  // 废弃于API23，加载资源时出错
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @TargetApi(Build.VERSION_CODES.M)
            @Override  // 在API23添加,加载资源时出错
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override  // 加载资源时出现http错误
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }

            @Override  // url加载完成
            public void onPageFinished(WebView view, String url) {
                mOtherActionListener.otherAction(url);
                super.onPageFinished(view, url);
            }

            @Override  // 在API24被废弃，拦截页面加载，返回true表示拦截并处理点击事件，返回false则为超链接会在当前webview中加载
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @TargetApi(Build.VERSION_CODES.N)
            @Override  // 在API24添加，拦截页面加载，返回true表示拦截并处理点击事件，返回false则为超链接会在当前webview中加载
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        };
    }

    /**
     * 其他额外操作用listener来实现
     */
    public void setOtherActionListener(OtherActionListener otherActionListener) {
        this.mOtherActionListener = otherActionListener;
    }

    interface OtherActionListener {
        void otherAction(String str);
    }
}
