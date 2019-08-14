package com.example.sd.learningproject.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class MenuStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_start);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    void gotoOtherActivity(View view) {
        switch (view.getId()) {
            case R.id.button1:
                gotoActivity(SimpleMenuActivity.class);
                break;

            case R.id.button2:
                gotoActivity(SimpleJavaMenuActivity.class);
                break;

            case R.id.button3:
                gotoActivity(OptionsMenuFragmentActivity.class);
                break;

            case R.id.button4:
                gotoActivity(ContextMenuActivity.class);
                break;

            case R.id.button5:
                gotoActivity(PopupMenuActivity.class);
                break;
        }
    }

    private void gotoActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
