package com.example.aopdemo;

import android.app.Activity;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author 张本志
 * @since 2019-12-30 14:40
 */
@Aspect
public class AspectTest {

    @Before("execution(* com.example.aopdemo.Animal.fly(..))")
    public void beforMethod() {
        Log.e("TAG", "beforMethod...");
    }

    @After("execution(* com.example.aopdemo.BaseActivity.onCreate(..))")
    public void trackAppViewScreen(JoinPoint joinPoint) {
        String title = "";
        if (joinPoint != null && joinPoint.getThis() instanceof Activity) {
            // 获取该Activity的title埋点
            title = ((Activity) joinPoint.getThis()).getTitle().toString();
        }
        Log.e("TAG", "埋点在MainActivity的onCreate()" + title);
    }

    @Before("execution(* com.example.aopdemo.MainActivity.onCreateView(..))")
    public void beforOnCreateView() {
        Log.e("TAG", "beforOnCreateView");
    }


}
