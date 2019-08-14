package com.example.sd.learningproject.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.sd.learningproject.R;

/**
 * 弹出菜单
 */
public class PopupMenuActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_left);

        ButterKnife.bind(this);
        mButton.setText(getString(R.string.text_button_click_show_popup_menu));
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(PopupMenuActivity.this, v);
                getMenuInflater().inflate(R.menu.context_menu, popupMenu.getMenu());  // 加载menu资源

                // 为弹出菜单设置监听
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_add:
                                Toast.makeText(PopupMenuActivity.this, "You clicked Setting", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.item_remove:
                                Toast.makeText(PopupMenuActivity.this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                                return true;

                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

}
