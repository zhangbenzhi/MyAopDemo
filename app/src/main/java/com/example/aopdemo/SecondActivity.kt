package com.example.aopdemo

import android.os.Bundle
import android.os.PersistableBundle

/**
 *
 * @author 张本志
 * @since 2020-01-06 15:50
 */
class SecondActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main2)
        setTitle("\"kotlin页面\"")
    }


}