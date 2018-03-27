package com.syc.mywechat;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * 类描述:
 * 创建人:一一哥
 * 创建时间:16/11/18 09:43
 * 备注:
 */

class FragmentFactory {

    private static final int WECHAT = 0;
    private static final int CONTACTS = 1;
    private static final int FIND = 2;
    private static final int ME = 3;
    //private static List<Fragment> fragments = new ArrayList<>();
    //如果要根据key=0,1,2等整型值获取一个value,此时可以用SparseArray
    private static SparseArray<Fragment> fragments = new SparseArray<>();
//创建fragment的方法
    static Fragment createFragment(int index) {
        //先从集合中取Fragment对象
        Fragment fragment = fragments.get(index);
        if (fragment == null) {//如果取出的集合为空则new对应的fragment
            switch (index) {
                case WECHAT:
                    fragment = new WeChatFragment();
                    break;
                case CONTACTS:
                    fragment = new ContactsFragment();
                    break;
                case FIND:
                    fragment = new FindFragment();
                    break;
                case ME:
                    fragment = new MeFragment();
                    break;
            }
            //存放到集合中
            fragments.put(index, fragment);
        }

        return fragment;
    }
}
