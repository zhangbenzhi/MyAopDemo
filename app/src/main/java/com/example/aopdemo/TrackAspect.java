package com.example.aopdemo;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 埋点aspect:
 *
 * @author 张本志
 * @since 2019-12-30 19:26
 */
@Aspect
public class TrackAspect {

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
    @Pointcut("execution(* android.view.View.OnClickListener+.onClick(..)) && args(view)")
    public void onClick(View view) {
    }

    @After("onClick()")
    public void trackViewClick(JoinPoint joinPoint) {
        String content = "";
        if (joinPoint instanceof Button) {
            content = ((Button) joinPoint).getText().toString();
        } else if (joinPoint instanceof TextView) {
            content = ((TextView) joinPoint).getText().toString();
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

}
