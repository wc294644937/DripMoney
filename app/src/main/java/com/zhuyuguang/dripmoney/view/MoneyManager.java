package com.zhuyuguang.dripmoney.view;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 钱币的管理类
 * Created by 玉光 on 2016-8-29.
 */
public class MoneyManager {
    /**
     * 钱币的管理集合
     */
    public static List<Money> moneys ;
    public static int number = 0;

    /**
     * 产生储存五个钱对象的集合
     * @param x
     * @param y
     * @return
     */
    public static List<Money> createMoney( float x, float y) {
        moneys = new ArrayList<>();
        Money money = null;
        for (int i = 0; i < 10; i++) {
            money = new Money(x, y);
            moneys.add(money);

        }
        return moneys;
    }

    /**
     * 更新储存钱对象的集合
     * @param moneys
     * @param view
     * @param x
     * @param y
     * @return
     */
    public static List<Money> updateMoneys(List<Money> moneys, View view, float x, float y) {
        //获取屏幕的宽高
//        WindowManager wm = (WindowManager) context
//                .getSystemService(Context.WINDOW_SERVICE);
        List<Money> moneyList=new ArrayList<>();
        int width =view.getMeasuredWidth();// wm.getDefaultDisplay().getWidth();
        int height =view.getMeasuredHeight();// wm.getDefaultDisplay().getHeight();
        //更新集合里面每个对象的坐标
        for (Money money : moneys) {
            money.updateLocation();
            if (money.locationX>0&&money.locationX<width&&money.locationY>0&&money.locationY<height){
                moneyList.add(money);

            }
        }
//        //去除集合中超过屏幕的部分
//        for (int i = 0; i >=moneys.size() ; i++) {
//            if (!(moneys.get(i).locationX<0||moneys.get(i).locationX>width||moneys.get(i).locationY<0||moneys.get(i).locationY>height)){
//            }else {
//                moneyList.add(moneys.get(i));
//            }
//
//        }
        if (number<10) {
            //在添加五个进去
            moneyList.addAll(createMoney(x, y));
            number++;
        }
        return moneyList;
    }


}