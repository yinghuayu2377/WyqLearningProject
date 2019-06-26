package com.example.sd.learningproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.sd.learningproject.intent.Intent1Activity;
import com.example.sd.learningproject.menu.SimpleMenuActivity;
import com.example.sd.learningproject.webView.WebViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.webview_button:
                Intent intent1 = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent1);
                break;

            case R.id.menu_button:
                Intent intent2 = new Intent(MainActivity.this, SimpleMenuActivity.class);
                startActivity(intent2);
                break;

            case R.id.intent_button:
                Intent intent3 = new Intent(MainActivity.this, Intent1Activity.class);
                startActivity(intent3);
                break;
        }
    }
}
