package com.example.sd.learningproject.storage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

import java.io.*;

/**
 * 将数据保存到文件中
 */
public class FileSaveActivity extends AppCompatActivity {
    @BindView(R.id.text_view_1)
    TextView mTextViewFirst;
    @BindView(R.id.text_view_2)
    TextView mTextViewSecond;

    private String data = "Data to save";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_save);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button1:
                save();
                break;

            case R.id.button2:
                storage();
                break;

            case R.id.button3:
                String string = load();
                if (!TextUtils.isEmpty(string)) {
                    mTextViewFirst.setText(string);
                }
                break;

            case R.id.button4:
                String content = loadExternal();
                if (!TextUtils.isEmpty(content)) {
                    mTextViewSecond.setText(content);
                }
                break;
        }
    }

    private void save() {  // 将数据存储在内部存储中
        FileOutputStream outputStream = null;
        BufferedWriter writer = null;
        try {
            outputStream = openFileOutput("wyqfile111", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void storage() {  // 将数据存储在外部存储中
        File file = null;
        FileOutputStream fileOutputStream = null;
//        String dir = Environment.getExternalStorageDirectory() + "/";  // 外部存储根目录下
        String dir = getExternalFilesDir("").getAbsolutePath() + "/";  // 外部存储下包名文件夹下的files文件中
        try {
            file = new File(dir + "wyqfile.txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes("utf-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String load() {  // 从内部存储中读取数据
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            inputStream = openFileInput("wyqfile111");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    private String loadExternal() {  // 从外部存储中读取数据
        File file = null;
        BufferedReader reader = null;
        FileInputStream fileInputStream = null;
        StringBuilder content = new StringBuilder();

        String dir = getExternalFilesDir("").getAbsolutePath() + "/";  // 外部存储下包名文件夹下的files文件中
        try {
            file = new File(dir + "wyqfile.txt");
            fileInputStream = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
