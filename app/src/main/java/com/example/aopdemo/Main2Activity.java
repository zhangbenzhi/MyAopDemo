package com.example.aopdemo;

import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("主页面2");
        Log.e("TAG", "Main2Activity onCreate()");
    }
}
