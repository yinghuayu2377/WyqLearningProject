package com.example.sd.learningproject.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.sd.learningproject.R;

/**
 * 在fragment中构建menu
 */
public class OptionsMenuFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);  // 为true表明fragment需要加载菜单项

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.simple_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                Toast.makeText(this.getActivity(), "You clicked Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_remove:
                Toast.makeText(this.getActivity(), "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this.getActivity(), "You clicked other menu item", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
