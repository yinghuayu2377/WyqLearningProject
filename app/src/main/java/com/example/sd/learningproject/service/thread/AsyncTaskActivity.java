package com.example.sd.learningproject.service.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;

public class AsyncTaskActivity extends AppCompatActivity {
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.text_view)
    TextView mTextView;

    private DownloadTask mTask = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        ButterKnife.bind(this);

        mTask = new DownloadTask();
    }

    @OnClick({R.id.start_button, R.id.cancel_button})
    void click(View view) {
        switch (view.getId()) {
            case R.id.start_button:
                mTask.execute();  // 开始执行
                break;
            case R.id.cancel_button:
                mTask.cancel(true);  // 取消
                break;
        }
    }

    private class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {  // 会在后台任务开始之前调用，用于进行一些界面上的初始化操作
            mTextView.setText("加载中");
        }

        @Override
        protected Boolean doInBackground(Void... voids) {   // 这个方法中的代码会在子线程中执行，应该在这里处理所有耗时操作；这个方法中不可进行UI操作;
            // 如果需要更新UI，可以调用publishProgress()方法来完成
            try {
                int count = 0;
                int length = 1;
                while (count < 99) {
                    count += length;
                    publishProgress(count);
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {   // 当在后台任务中调用了publishProgress()方法后，此方法就会被调用；参数就是在后台任务中传递过来的
            // 此方法中可以对UI进行操作
            mProgressBar.setProgress(values[0]);
            mTextView.setText("loading..." + values[0] + "%");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {  // 后台任务执行完毕并通过return语句返回后时，这个方法会调用，返回的数据会作为参数传递到此方法中
            mTextView.setText("加载完毕");
        }

        @Override
        protected void onCancelled() {
            mTextView.setText("已取消");
            mProgressBar.setProgress(0);
        }
    }
}
