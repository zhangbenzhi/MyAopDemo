package com.example.aopdemo;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author 张本志
 * @since 2020-01-06 18:08
 */
@Aspect
public class TestAspectJ {

    /**
     * 统计activity页面浏览事件
     */
    @After("execution(* com.example.aopdemo.BaseActivity.onCreate(..))")
    public void trackAppViewScreen(JoinPoint joinPoint) {
        String title = "";
        if (joinPoint != null && joinPoint.getThis() != null) {
            Object joinPointThis = joinPoint.getThis();
            if (joinPointThis instanceof Activity) {
                title = ((Activity) joinPointThis).getTitle().toString();
            }
        }
        Log.e("TAG", "trackAppViewScreen:标题为=" + title);
    }

    /**
     * 统计view的点击事件
     * 为什么要使用OnclickListener+，因为：
     * 不使用"+"则setOnClickListener(new OnClickListener() {…}) 这种匿名内部类写法时没问题
     * 但是如果是实现 OnClickListener 接口的类则无法切入。所以应该加上 OnClickListener 的子类
     * ！！！！实际中好像并没什么影响
     */
    @After("execution(* android.view.View.OnClickListener+.onClick(..)) && args(view)")
    public void trackViewClick(View view) {
        String content = "";
        if (view instanceof Button) {
            content = ((Button) view).getText().toString();
        } else if (view instanceof TextView) {
            content = ((TextView) view).getText().toString();
        }
        Log.e("TAG", "trackViewClick:元素内容=" + content);
    }

    /**
     * 统计网络请求返回数据成功
     * !!!注意必须要写上args(roomBean)限定该方法的参数为RoomBean
     */
    @After("execution(* com.example.aopdemo.MainActivity.onDataLoaded(..)) && args(roomBean)")
    public void onDataLoaded(RoomBean roomBean) {
        Log.e("TAG", "拿到的房间名称:" + roomBean.roomName);
    }

    /**
     * 在抛出异常的方法处切点
     */
    @After("execution(* *(..) throws NullPointerException)")
    public void onCrash() {
        Log.e("TAG", "捕获了。。。。");
    }

    /**
     * kotlin类方法调用时
     */
    @After("execution(* com.example.aopdemo.TestKottlin.get(..))")
    public void onGetKotlin() {
        Log.e("TAG", "getKotlin....");
    }

}
