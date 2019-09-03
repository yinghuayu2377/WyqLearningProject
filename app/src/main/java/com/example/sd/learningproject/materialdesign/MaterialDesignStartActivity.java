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
import com.example.sd.learningproject.materialdesign.toolbar.ToolBarActivity;

public class MaterialDesignStartActivity extends AppCompatActivity {
    @BindView(R.id.button1)
    Button mButton1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_tool_bar_activity));
    }

    @OnClick({R.id.button1})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                gotoActivity(ToolBarActivity.class);
                break;
        }
     }

     private void gotoActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
     }
}