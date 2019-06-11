package com.example.sd.learningproject.webView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.webView.basewebview.TestWebViewActivity;
import com.example.sd.learningproject.webView.simplewebview.SimpleWebViewActivity;

public class WebViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_part_webview);

        Button mSimpleWebViewButton = (Button) findViewById(R.id.simple_webview_button);
        mSimpleWebViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(WebViewActivity.this, SimpleWebViewActivity.class);
                startActivity(intent1);
            }
        });

        Button mBaseWebViewButton = (Button) findViewById(R.id.base_webview_button);
        mBaseWebViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(WebViewActivity.this, TestWebViewActivity.class);
                startActivity(intent2);
            }
        });
    }
}
