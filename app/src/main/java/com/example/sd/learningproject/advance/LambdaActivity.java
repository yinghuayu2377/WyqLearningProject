package com.example.sd.learningproject.advance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

/**
 * Lambda表达式的使用
 */
public class LambdaActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button mButton1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_click));

        showThreadLambda();
        showListenerLambda();
        showCustomListenerLambda();
    }

    private void showThreadLambda() {
        new Thread(() -> {
            // 这里执行耗时操作
        }).start();
    }

    private void showListenerLambda() {
        mButton1.setOnClickListener(view -> {
        });
    }

    private void showCustomListenerLambda() {
        hello((a, b) -> {
            String result = a + b;
            return result;
        });
    }

    private void hello(MyListener listener) {
        String a = "Hello Lambda";
        int b = 1024;
        String result = listener.doSomething(a, b);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    private interface MyListener {
        String doSomething(String a, int b);
    }
}
