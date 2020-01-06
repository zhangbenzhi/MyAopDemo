package com.example.aopdemo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("主页面");

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "登录", Toast.LENGTH_SHORT).show();
            }
        });

        // 模拟数据请求
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onDataLoaded(new RoomBean("123323", "官悦欣园", "23323"));
            }
        }, 300);
    }

    public void onDataLoaded(RoomBean roomBean) {

    }
}
