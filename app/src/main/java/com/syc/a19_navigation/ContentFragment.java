package com.syc.a19_navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 类描述:
 * 创建人:一一哥
 * 创建时间:16/11/18 09:18
 * 备注:
 */

public class ContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int index = bundle.getInt("index", 0);
            tvMsg.setText("第" + (index + 1) + "个Fragment!");
        }
    }
}
