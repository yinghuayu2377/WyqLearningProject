package com.example.sd.learningproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.advance.AdvanceActivity;
import com.example.sd.learningproject.broadcastreceiver.BroadcastReceiverStartActivity;
import com.example.sd.learningproject.contentProvider.ContentProviderStartActivity;
import com.example.sd.learningproject.fragment.FragmentStartActivity;
import com.example.sd.learningproject.intent.Intent1Activity;
import com.example.sd.learningproject.internet.InternetStartActivity;
import com.example.sd.learningproject.lifecycle.LifeCycleActivity;
import com.example.sd.learningproject.listview.ListViewActivity;
import com.example.sd.learningproject.location.LocationActivity;
import com.example.sd.learningproject.location.LocationStartActivity;
import com.example.sd.learningproject.menu.MenuStartActivity;
import com.example.sd.learningproject.multimedia.NotificationStartActivity;
import com.example.sd.learningproject.permission.PermissionActivity;
import com.example.sd.learningproject.recyclerview.RecyclerViewStartActivity;
import com.example.sd.learningproject.storage.StorageActivity;
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
            R.id.list_view_button, R.id.recycler_view_button, R.id.fragment_button, R.id.broadcast_receiver_button,
            R.id.memory_button, R.id.dynamic_apply_permission_button, R.id.content_resolver, R.id.notification,
            R.id.advance, R.id.internet, R.id.location})
    void clickButton(View v) {
        switch (v.getId()) {
            case R.id.webview_button:
                gotoOtherActivity(WebViewActivity.class);
                break;

            case R.id.menu_button:
                gotoOtherActivity(MenuStartActivity.class);
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

            case R.id.recycler_view_button:
                gotoOtherActivity(RecyclerViewStartActivity.class);
                break;

            case R.id.fragment_button:
                gotoOtherActivity(FragmentStartActivity.class);
                break;

            case R.id.broadcast_receiver_button:
                gotoOtherActivity(BroadcastReceiverStartActivity.class);
                break;

            case R.id.memory_button:
                gotoOtherActivity(StorageActivity.class);
                break;

            case R.id.dynamic_apply_permission_button:
                gotoOtherActivity(PermissionActivity.class);
                break;

            case R.id.content_resolver:
                gotoOtherActivity(ContentProviderStartActivity.class);
                break;

            case R.id.notification:
                gotoOtherActivity(NotificationStartActivity.class);
                break;

            case R.id.advance:
                gotoOtherActivity(AdvanceActivity.class);
                break;

            case R.id.internet:
                gotoOtherActivity(InternetStartActivity.class);
                break;

            case R.id.location:
                gotoOtherActivity(LocationStartActivity.class);
                break;
        }
    }

    private void gotoOtherActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
