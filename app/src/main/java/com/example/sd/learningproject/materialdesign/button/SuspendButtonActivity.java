package com.example.sd.learningproject.materialdesign.button;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

/**
 * 悬浮按钮
 */
public class SuspendButtonActivity extends AppCompatActivity {

    @BindView(R.id.floating_action_button)
    FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspend_button);
        ButterKnife.bind(this);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Data deleted", Snackbar.LENGTH_SHORT)  // 使用Snackbar
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SuspendButtonActivity.this, "FAB clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}
