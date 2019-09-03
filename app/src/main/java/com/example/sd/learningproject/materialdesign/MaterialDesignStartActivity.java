package com.example.sd.learningproject.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.materialdesign.button.SuspendButtonActivity;
import com.example.sd.learningproject.materialdesign.drawerlayout.DrawerLayoutActivity;
import com.example.sd.learningproject.materialdesign.toolbar.ToolBarActivity;

public class MaterialDesignStartActivity extends AppCompatActivity {
    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_tool_bar_activity));
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(getString(R.string.text_suspend_button));
        mButton3.setVisibility(View.VISIBLE);
        mButton3.setText(getString(R.string.text_drawer_layout));
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                gotoActivity(ToolBarActivity.class);
                break;
            case R.id.button2:
                gotoActivity(SuspendButtonActivity.class);
                break;
            case R.id.button3:
                gotoActivity(DrawerLayoutActivity.class);
                break;
        }
    }

    private void gotoActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
