package com.example.sd.learningproject.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.sd.learningproject.R;

/**
 * 用java代码构建的普通选项菜单
 */
public class SimpleJavaMenuActivity extends AppCompatActivity {
    private boolean isShow = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  // 只会调用一次
        MenuItem item1 = menu.add(0, 1, 1, "设置");
        item1.setIcon(R.drawable.icon_blue_setting);
        item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        MenuItem item2 = menu.add(0, 2, 2, "删除");
        item2.setIcon(R.drawable.icon_delete);
        item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {  // 重新对菜单进行处理
        menu.getItem(0).setVisible(isShow);
        return super.onPrepareOptionsMenu(menu);
    }

    void updateIsShow(boolean isShow) {
        this.isShow = isShow;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            Toast.makeText(this, "You clicked Setting", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == 2) {
//            Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
            updateIsShow(!isShow);
            invalidateOptionsMenu();  // 通知更新menu
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
