package com.example.sd.learningproject.internet;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.DynamicModule;
import com.example.sd.learningproject.Module;
import com.example.sd.learningproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Json相关
 */
public class JsonActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;
    @BindView(R.id.button4)
    Button mButton4;

    private static final String TAG = "GSON";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_start);
        ButterKnife.bind(this);

        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(getString(R.string.text_json_list));
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(getString(R.string.text_json_object));
        mButton3.setVisibility(View.VISIBLE);
        mButton3.setText(getString(R.string.text_json_map));
        mButton4.setVisibility(View.VISIBLE);
        mButton4.setText(getString(R.string.text_object_to_json));
    }

    private String getJson(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            AssetManager assetManager = getApplicationContext().getAssets();
            InputStream inputStream = assetManager.open(fileName);
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = bf.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                String string = getJson("package.json");
                Gson gson = new Gson();
                List<DynamicModule> modules = gson.fromJson(string, new TypeToken<List<DynamicModule>>() {
                }.getType());
                for (DynamicModule module : modules) {
                    Log.e(TAG, module.getName());
                }
                break;
            case R.id.button2:
                String string1 = getJson("module.json");
                Module module = new Gson().fromJson(string1, Module.class);
                Log.e(TAG, module.getCode());
                Log.e(TAG, module.getName());
                Log.e(TAG, String.valueOf(module.getCtrlMode()));
                break;
            case R.id.button3:
                String string2 = getJson("module.json");
                Map map = new Gson().fromJson(string2, Map.class);
                Log.e(TAG, (String) map.get("code"));
                Log.e(TAG, (String) map.get("name"));
                Log.e(TAG, String.valueOf((double) map.get("ctrlMode")));
                break;
            case R.id.button4:
                Module module1 = new Module();
                module1.setCode("002");
                module1.setName("mantianxing");
                module1.setCtrlMode(1);
                String jsonString = new Gson().toJson(module1);
                Log.e(TAG, jsonString);
                break;
        }
    }
}
