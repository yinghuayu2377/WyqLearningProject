package com.example.sd.learningproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.intent.Intent1Activity;
import com.example.sd.learningproject.lifecycle.LifeCycleActivity;
import com.example.sd.learningproject.menu.SimpleMenuActivity;
import com.example.sd.learningproject.webView.WebViewActivity;
import com.example.sd.learningproject.widget.NormalWidgetActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick({R.id.webview_button, R.id.menu_button, R.id.intent_button, R.id.life_cycle_button, R.id.widget_button})
    void clickButton(View v) {
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

            case R.id.life_cycle_button:
                Intent intent4 = new Intent(MainActivity.this, LifeCycleActivity.class);
                startActivity(intent4);
                break;

            case R.id.widget_button:
                Intent intent5 = new Intent(MainActivity.this, NormalWidgetActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
