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
import com.example.sd.learningproject.advance.extra.ParcelableActivity;
import com.example.sd.learningproject.advance.extra.ParcelablePerson;
import com.example.sd.learningproject.advance.extra.Person;
import com.example.sd.learningproject.advance.extra.SerializableActivity;
import com.example.sd.learningproject.advance.time.AlarmActivity;

/**
 * 进阶部分
 */
public class AdvanceActivity extends AppCompatActivity {
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
        mButton1.setText(getString(R.string.text_put_serializable));
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(getString(R.string.text_put_parcelable));
        mButton3.setVisibility(View.VISIBLE);
        mButton3.setText(getString(R.string.text_advance_time));
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
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

            case R.id.button2:
                ParcelablePerson person1 = new ParcelablePerson();
                person1.setName("mantianxing");
                person1.setAge(20);
                Intent intent1 = new Intent(this, ParcelableActivity.class);
                intent1.putExtra("data2", person1);
                startActivity(intent1);
                break;

            case R.id.button3:
                Intent intent2 = new Intent(this, AlarmActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
