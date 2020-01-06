package com.example.aopdemo

import android.os.Bundle

/**
 *
 * @author 张本志
 * @since 2020-01-06 15:50
 */
class SecondActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)
        title = "kotlin页面"
    }


}