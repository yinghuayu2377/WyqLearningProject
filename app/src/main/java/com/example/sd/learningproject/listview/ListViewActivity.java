package com.example.sd.learningproject.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;
import com.example.sd.learningproject.listview.customlistview.CustomListActivity;

public class ListViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, NormalListViewActivity.class);
                startActivity(intent);
                break;

            case R.id.button2:
                Intent intent1 = new Intent(this, CustomListActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
