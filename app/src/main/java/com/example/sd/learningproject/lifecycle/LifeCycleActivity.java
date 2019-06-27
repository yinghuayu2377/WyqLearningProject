package com.example.sd.learningproject.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = "LiftCycle";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        ButterKnife.bind(this);

        Log.e(TAG, "onCreate()");
    }

    @OnClick({R.id.click_normal_activity, R.id.click_dialog_activity})
    void click(View view) {
        switch (view.getId()) {
            case R.id.click_normal_activity:
                Intent intent = new Intent(this, NormalActivity.class);
                startActivity(intent);
                break;

            case R.id.click_dialog_activity:
                Intent intent1 = new Intent(this, DialogActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart()");
    }
}
