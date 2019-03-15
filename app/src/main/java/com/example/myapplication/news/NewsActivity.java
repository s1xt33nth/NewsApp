package com.example.myapplication.news;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.R;


public class NewsActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Fragment fga, fgb, fgc, fgd;

    private long exitTime = 0;

    private RadioGroup radioGroup;
    private RadioButton rb_channel;
    private FrameLayout frameLayout;


    private FragmentManager fragmentManager;

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        //获得Fragment管理器
        fragmentManager = getSupportFragmentManager();

        initView();
    }

    private void initView() {
        frameLayout = findViewById(R.id.frameLayout);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态
        rb_channel = findViewById(R.id.rb_channel);
        rb_channel.setChecked(true);

//        addFragment(new FragmentA());
    }


    public void addFragment(Fragment fragment) {
        //获得Fragment管理器
        fragmentManager = getSupportFragmentManager();
        //使用管理器开启事务
        fragmentTransaction = fragmentManager.beginTransaction();
        //使用事务替换Fragment容器中Fragment对象
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        //提交事务，否则事务不生效
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 0) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出NewsApp", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                super.onBackPressed();
            }
        } else {
            fragmentManager.popBackStack();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //使用管理器开启事务
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (checkedId){
            case R.id.rb_channel:
                if(fga == null){
                    fga = new FragmentA(fragmentManager);
                    fragmentTransaction.add(R.id.frameLayout, fga);
                }else{
                    fragmentTransaction.show(fga);
                }
                break;
            case R.id.rb_message:
                if(fgb == null){
                    fgb = new FragmentB();
                    fragmentTransaction.add(R.id.frameLayout, fgb);
                }else{
                    fragmentTransaction.show(fgb);
                }
                break;
            case R.id.rb_better:
                if(fgc == null){
                    fgc = new FragmentC();
                    fragmentTransaction.add(R.id.frameLayout, fgc);
                }else{
                    fragmentTransaction.show(fgc);
                }
                break;
            case R.id.rb_setting:
                if(fgd == null){
                    fgd = new FragmentD();
                    fragmentTransaction.add(R.id.frameLayout, fgd);
                }else{
                    fragmentTransaction.show(fgd);
                }
                break;
        }
        //提交事务，否则事务不生效
        fragmentTransaction.commit();
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fga != null)fragmentTransaction.hide(fga);
        if(fgb != null)fragmentTransaction.hide(fgb);
        if(fgc != null)fragmentTransaction.hide(fgc);
        if(fgd != null)fragmentTransaction.hide(fgd);
    }

}
