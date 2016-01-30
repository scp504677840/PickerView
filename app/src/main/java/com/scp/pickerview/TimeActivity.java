package com.scp.pickerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间选择器
 */
public class TimeActivity extends AppCompatActivity {
    private TimePickerView pvTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        //时间选择器
        pvTime = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY);
        //设置标题
        pvTime.setTitle("选择日期");
        //控制时间范围
        Calendar calendar = Calendar.getInstance();
        pvTime.setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR));
        pvTime.setTime(new Date());
        //设置是否循环
        pvTime.setCyclic(false);
        //设置是否可以关闭
        pvTime.setCancelable(true);
        //设置选择监听
        pvTime.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date) {
                Log.e("MainActivity", "当前选择时间：" + getTime(date));
            }
        });
        //显示
        pvTime.show();
    }

    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }
}
