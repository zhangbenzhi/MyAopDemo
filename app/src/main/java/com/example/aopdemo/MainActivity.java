package com.example.aopdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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

        findViewById(R.id.btn_jump_to).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        // 模拟数据请求
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onDataLoaded(new RoomBean("123323", "官悦欣园", "23323"));
            }
        }, 300);

        try {
            toLow(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TestKottlin.INSTANCE.get();
    }

    public void onDataLoaded(RoomBean roomBean) {

    }

    public void toLow(String msg) throws NullPointerException {
        Log.e("TAG", "异常了....");
        msg.toLowerCase();
    }
}
