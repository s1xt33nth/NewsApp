package com.example.myapplication.news;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentA extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Context mContext;
    private ArrayList<Data> datas = null;
    private FragmentManager fragmentManager;

    public FragmentA() {
    }

    public FragmentA(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta_layout, container, false);
        initView(view);
        initData();
        setFragmentAdapter();
        return view;
    }

    /**
     * 初始化控件
     */
    private void initView(View view) {
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tablayout);
    }

    /**
     * 数据源
     */
    private void initData() {

        datas = new ArrayList<>();

        datas.add(new Data("百度新闻", "https://www.baidu.com/", R.mipmap.baidu));
        datas.add(new Data("搜狐新闻", "https://m.sohu.com/", R.mipmap.sohu));
        datas.add(new Data("腾讯新闻", "https://xw.qq.com/", R.mipmap.tencent));
        datas.add(new Data("新浪新闻", "https://news.sina.cn/", R.mipmap.xl));
        datas.add(new Data("网易新闻", "https://news.163.com/", R.mipmap.netease));
        datas.add(new Data("今日头条", "https://www.toutiao.com/", R.mipmap.jr));
        datas.add(new Data("澎湃新闻", "https://www.thepaper.cn/", R.mipmap.pp));
        datas.add(new Data("好奇心日报", "https://www.qdaily.com/", R.mipmap.hqx));
        datas.add(new Data("新华网", "https://www.xinhuanet.com/", R.mipmap.xh));
        datas.add(new Data("人民网", "https://www.people.com.cn/", R.mipmap.rm));

    }

    private void setFragmentAdapter() {
        String[] strings = new String[]{"新闻", "图片", "天气"};

        List<Fragment> list = new ArrayList<>();
        list.add(new NewListFragment(fragmentManager, datas));
        list.add(new FragmentTwo());
        list.add(new FragmentThree());
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(), list, strings);
        viewPager.setAdapter(myViewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabTextColors(ContextCompat.getColor(getActivity(), R.color.white), ContextCompat.getColor(getActivity(), R.color.pink));

    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
