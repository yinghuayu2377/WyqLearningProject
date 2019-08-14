package com.example.sd.learningproject.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

/**
 * 上下文菜单
 */
public class ContextMenuActivity extends AppCompatActivity {
    @BindView(R.id.button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_left);

        ButterKnife.bind(this);
        mButton.setText(getString(R.string.text_button_long_click_show_context_menu));

        registerForContextMenu(mButton); // 为button注册上下文浮动菜单
    }

    // 创建上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                Toast.makeText(this, "You clicked Setting", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_remove:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
