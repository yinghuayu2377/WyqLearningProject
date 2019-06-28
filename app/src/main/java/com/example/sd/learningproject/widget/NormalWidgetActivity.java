package com.example.sd.learningproject.widget;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class NormalWidgetActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_widget);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.alert_dialog_button})
    void click(View view) {
        switch (view.getId()) {
            case R.id.alert_dialog_button:  // AlertDialog
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("This is a dialog");
                dialog.setMessage("Something importent.");
                dialog.setCancelable(false);
                dialog.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(NormalWidgetActivity.this,"点了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(NormalWidgetActivity.this,"点了取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
        }
    }
}
