package com.example.sd.learningproject.location;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.*;
import com.baidu.mapapi.model.LatLng;
import com.example.sd.learningproject.R;

/**
 * 地图
 */
public class BaiduMapActivity extends AppCompatActivity {
    @BindView(R.id.map_view)
    MapView mMapView;

    private BaiduMap mBaiduMap;  // 地图总控制器
    private boolean isFirstLocate = true;
    private LocationClient mClient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SDKInitializer.initialize(getApplicationContext());  // 要放入setContentView前操作
        setContentView(R.layout.activity_baidu_map);
        ButterKnife.bind(this);

        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);  // 展示"我"的位置小光标
        mClient = new LocationClient(getApplicationContext());
        mClient.registerLocationListener(new MyLocation());

        // 这里省略对权限的检查
        mClient.start();
    }

    private void navigateTo(BDLocation location) {
        if(isFirstLocate) {
            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            mBaiduMap.animateMapStatus(update);  //将地图移到某个经纬度

            update = MapStatusUpdateFactory.zoomTo(16f);
            mBaiduMap.animateMapStatus(update);  // 设置缩放级别
            isFirstLocate = false;
        }
        MyLocationData.Builder builder = new MyLocationData.Builder();
        builder.latitude(location.getLatitude());
        builder.longitude(location.getLongitude());
        MyLocationData data = builder.build();
        mBaiduMap.setMyLocationData(data);
    }

    public class MyLocation extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if(bdLocation.getLocType() == BDLocation.TypeGpsLocation || bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                navigateTo(bdLocation);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mClient.stop();
        mMapView.onDestroy();
        mBaiduMap.setMyLocationEnabled(false);
    }
}
