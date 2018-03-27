package com.syc.mywechat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//实现视图的点击监听类
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup rgNavigations;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//1、viewpager&radiogroup
        vp = (ViewPager) findViewById(R.id.vp);
        rgNavigations = (RadioGroup) findViewById(R.id.rg_bottom);
//2、viewpager设置适配器，new Adapter  得到支持fragment管理器
        vp.setAdapter(new WeAdapter(getSupportFragmentManager()));

        //通过ViewPager的切换,来实现底部导航栏的切换.
        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                ((RadioButton) rgNavigations.getChildAt(position)).setChecked(true);
            }
        });

        //通过底部导航栏的切换,来实现ViewPager的切换.
        for(int i=0;i<rgNavigations.getChildCount();i++){
            //存值
            rgNavigations.getChildAt(i).setTag(i);
            rgNavigations.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        //切换ViewPager到某个页面
        vp.setCurrentItem((int)v.getTag());
    }

    class WeAdapter extends FragmentPagerAdapter {

        WeAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createFragment(position);
        }

        @Override
        public int getCount() {
            return rgNavigations.getChildCount();
        }
    }
}
