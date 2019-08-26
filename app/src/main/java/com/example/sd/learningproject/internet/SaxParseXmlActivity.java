package com.example.sd.learningproject.internet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.XmlRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.sd.learningproject.R;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

/**
 * 使用SAX方式解析xml
 */
public class SaxParseXmlActivity extends AppCompatActivity {
    @BindView(R.id.text_view)
    TextView mTextView;

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
     * 使用SAX解析xml
     * xml结构为:
     * <resp>
     * <city>北京</city>
     * <updatetime>14:55</updatetime>
     * <wendu>25</wendu>
     * </resp>
     */
    private void parseXml(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXParser().getXMLReader();
            SaxHandler handler = new SaxHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
