package com.example.sd.learningproject.advance;

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
import com.example.sd.learningproject.advance.extra.Person;
import com.example.sd.learningproject.advance.extra.SerializableActivity;

/**
 * 进阶部分
 */
public class AdvanceActivity extends AppCompatActivity {
    @BindView(R.id.button1)
    Button mButton1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_put_serializable));

    }

    @OnClick({R.id.button1})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Person person = new Person();
                person.setName("mantianxing");
                person.setAge(20);
                Intent intent = new Intent(this, SerializableActivity.class);
                intent.putExtra("data1", person);
                startActivity(intent);
                break;
        }
    }
}
