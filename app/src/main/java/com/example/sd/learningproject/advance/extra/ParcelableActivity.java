package com.example.sd.learningproject.advance.extra;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

public class ParcelableActivity extends AppCompatActivity {

    @BindView(R.id.text_view_1)
    TextView mTextViewFirst;
    @BindView(R.id.text_view_2)
    TextView mTextViewSecond;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        ParcelablePerson person = (ParcelablePerson) intent.getParcelableExtra("data2");
        mTextViewFirst.setText(person.getName());
        mTextViewSecond.setText(String.valueOf(person.getAge()));
    }
}
