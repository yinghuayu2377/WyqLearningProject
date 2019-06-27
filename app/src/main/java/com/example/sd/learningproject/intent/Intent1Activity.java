package com.example.sd.learningproject.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class Intent1Activity extends AppCompatActivity {

    @BindView(R.id.text_view)
    TextView mTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.click_button1, R.id.click_button2, R.id.click_button3, R.id.click_button4, R.id.click_button5,
            R.id.click_button6, R.id.click_button7})
    void clikButton(View v) {
        switch (v.getId()) {
            case R.id.click_button1:  // 显式Intent
                Intent intent = new Intent(this, Intent2Activity.class);
                startActivity(intent);
                break;

            case R.id.click_button2:  // 隐式Intent--通过action、category调用本应用activity
                Intent intent1 = new Intent("com.example.sd.learningproject.ACTION_START");
                intent1.addCategory("com.example.sd.learningproject.MY_CATEGORY");
                startActivity(intent1);
                break;

            case R.id.click_button3:  // 隐式Intent--调用系统浏览器，在AndroidManifest.xml中配置
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("http://www.baidu.com"));  // 将字符串解析为Url对象，设置给setData()
                startActivity(intent2);
                break;

            case R.id.click_button4:  // 隐式Intent--拨打电话
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                intent3.setData(Uri.parse("tel:10086"));  // 将字符串解析为Url对象，设置给setData()
                startActivity(intent3);
                break;

            case R.id.click_button5:  // 隐式Intent--通过schema调用，在AndroidManifest.xml中配置
                // schema:指定数据的协议部分  example
                // host:指定主机名部分  com.example.sd
                // port:数据的端口部分
                // path:主机名和端口号之后的部分  /Intent3Activity
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("example://com.example.sd/Intent3Activity"));
                startActivity(intent4);
                break;

            case R.id.click_button6:  // 传递数据
                Intent intent5 = new Intent(this, Intent2Activity.class);
                intent5.putExtra("extra_data", "Hello World");
                startActivity(intent5);
                break;

            case R.id.click_button7: // 实现返回数据
                Intent intent6 = new Intent(this, Intent4Activity.class);
                startActivityForResult(intent6, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);  // requestCode为启动活动时传入的请求码，resultCode为返回数据时候的处理结果
        if(resultCode == RESULT_OK && requestCode == 1) {
            String string = data.getStringExtra("data_return");
            if(string != null && string.trim().length() != 0) {
                mTextView.setText(string);
            }
        }
    }
}
