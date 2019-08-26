package com.example.sd.learningproject.internet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

/**
 * 使用Pull方式解析xml
 */
public class PullParseXmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url_connection);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button})
    void click(View view) {
        switch (view.getId()) {
            case R.id.button:
                sendRequestWithOkHttp();
                break;
        }
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://wthrcdn.etouch.cn/WeatherApi?citykey=101010100")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    parseXml(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 使用Pull解析xml
     * xml结构为:
     * <resp>
     *   <city>北京</city>
     *   <updatetime>14:55</updatetime>
     *   <wendu>25</wendu>
     * </resp>
     */
    private void parseXml(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String city = "";
            String updatetime = "";
            String wendu = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    // 开始解析节点
                    case XmlPullParser.START_TAG:
                        if ("city".equals(nodeName)) {
                            city = xmlPullParser.nextText();
                        } else if ("updatetime".equals(nodeName)) {
                            updatetime = xmlPullParser.nextText();
                        } else if ("wendu".equals(nodeName)) {
                            wendu = xmlPullParser.nextText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("resp".equals(nodeName)) {
                            Log.e("TAG", "city:" + city + "updatetime:" + updatetime + "wendu:" + wendu);
                        }
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
