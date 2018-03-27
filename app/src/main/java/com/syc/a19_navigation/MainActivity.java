package com.syc.a19_navigation;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments;
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        PagerTabStrip strip = (PagerTabStrip) findViewById(R.id.tab_strip);
        strip.setBackgroundColor(Color.parseColor("#3E4EB8"));
        //是否绘制顶部的横线
        strip.setDrawFullUnderline(true);
        strip.setPadding(15,5,15,5);
        //设置指示器的颜色
        strip.setTabIndicatorColor(Color.parseColor("#479BFF"));
        strip.setTextSpacing(15);
        strip.setTextColor(Color.WHITE);

        titles = new String[]{"军事", "体育", "社会", "娱乐", "财经"};

        fragments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }

        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //用来设置每个页面对应的标题的
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
