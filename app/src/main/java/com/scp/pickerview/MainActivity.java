package com.scp.pickerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.OnDismissListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private OptionsPickerView<String> pvOptions;
    private ArrayList<String> optionsOne = new ArrayList<String>();
    private ArrayList<ArrayList<String>> optionsTwo = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<ArrayList<String>>> optionsThree = new ArrayList<ArrayList<ArrayList<String>>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initData();
        //初始化View
        initView();
    }

    private void initData() {
        //国家
        optionsOne.add("中国");
        optionsOne.add("韩国");
        //省
        ArrayList<String> optionsTwo_1 = new ArrayList<String>();
        optionsTwo_1.add("北京");
        optionsTwo_1.add("上海");
        optionsTwo_1.add("湖北");
        ArrayList<String> optionsTwo_2 = new ArrayList<String>();
        optionsTwo_2.add("首尔");
        optionsTwo_2.add("釜山");
        optionsTwo_2.add("大邱");
        optionsTwo.add(optionsTwo_1);
        optionsTwo.add(optionsTwo_2);
        //市
        ArrayList<ArrayList<String>> optionsThree_1 = new ArrayList<ArrayList<String>>();
        ArrayList<String> optionsThree_1_1 = new ArrayList<String>();
        optionsThree_1_1.add("北京市");
        optionsThree_1_1.add("朝阳区");
        optionsThree_1_1.add("玄武区");
        optionsThree_1.add(optionsThree_1_1);
        ArrayList<String> optionsThree_1_2 = new ArrayList<String>();
        optionsThree_1_2.add("上海市");
        optionsThree_1_2.add("静安区");
        optionsThree_1_2.add("闵行区");
        optionsThree_1.add(optionsThree_1_2);
        ArrayList<String> optionsThree_1_3 = new ArrayList<String>();
        optionsThree_1_3.add("武汉市");
        optionsThree_1_3.add("孝感市");
        optionsThree_1_3.add("安陆市");
        optionsThree_1.add(optionsThree_1_3);
        optionsThree.add(optionsThree_1);
        ArrayList<ArrayList<String>> optionsThree_2 = new ArrayList<ArrayList<String>>();
        ArrayList<String> optionsThree_2_1 = new ArrayList<String>();
        optionsThree_2_1.add("阳川区");
        optionsThree_2_1.add("道峰区");
        optionsThree_2_1.add("永登浦区");
        optionsThree_2.add(optionsThree_2_1);
        ArrayList<String> optionsThree_2_2 = new ArrayList<String>();
        optionsThree_2_2.add("釜山镇区");
        optionsThree_2_2.add("海云台区");
        optionsThree_2_2.add("莲堤区");
        optionsThree_2.add(optionsThree_2_2);
        ArrayList<String> optionsThree_2_3 = new ArrayList<String>();
        optionsThree_2_3.add("达城郡");
        optionsThree_2_3.add("寿城区");
        optionsThree_2_3.add("达西区");
        optionsThree_2.add(optionsThree_2_3);
        optionsThree.add(optionsThree_2);
    }

    private void initView() {
        //选项选择器
        pvOptions = new OptionsPickerView<String>(this);
        //三级联动
        pvOptions.setPicker(optionsOne, optionsTwo, optionsThree, true);
        //设置标题
        pvOptions.setTitle("选择城市");
        //设置是否可循环
        pvOptions.setCyclic(false, false, false);
        //设置标题
        //pvOptions.setLabels("国家", "省", "市");
        //设置确定监听
        pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                Log.e("MainActivity", "选择的是："
                        + optionsOne.get(options1)
                        + optionsTwo.get(options1).get(option2)
                        + optionsThree.get(options1).get(option2).get(options3));
            }
        });
        //设置消失监听
        pvOptions.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(Object o) {
                if (o instanceof OptionsPickerView) {
                    Log.e("MainActivity", "消失了是OptionsPickerView");
                } else {
                    Log.e("MainActivity", "消失了不是OptionsPickerView");
                }
            }
        });
        //显示
        pvOptions.show();
    }
}
