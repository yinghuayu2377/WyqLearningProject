package com.example.sd.learningproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.intent.Intent1Activity;
import com.example.sd.learningproject.lifecycle.LifeCycleActivity;
import com.example.sd.learningproject.listview.ListViewActivity;
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

    @OnClick({R.id.webview_button, R.id.menu_button, R.id.intent_button, R.id.life_cycle_button, R.id.widget_button,
            R.id.list_view_button})
    void clickButton(View v) {
        switch (v.getId()) {
            case R.id.webview_button:
                gotoOtherActivity(WebViewActivity.class);
                break;

            case R.id.menu_button:
                gotoOtherActivity(SimpleMenuActivity.class);
                break;

            case R.id.intent_button:
                gotoOtherActivity(Intent1Activity.class);
                break;

            case R.id.life_cycle_button:
                gotoOtherActivity(LifeCycleActivity.class);
                break;

            case R.id.widget_button:
                gotoOtherActivity(NormalWidgetActivity.class);
                break;

            case R.id.list_view_button:
                gotoOtherActivity(ListViewActivity.class);
                break;
        }
    }

    private void gotoOtherActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
