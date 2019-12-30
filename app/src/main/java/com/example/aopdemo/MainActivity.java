package com.example.aopdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreateView();
        setTitle("主页面");
        new Animal().fly();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        }, 300);
    }

    public void onCreateView() {
        Log.e("TAG", "onCreateView");
    }

}
