package com.example.myapplication.news;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.exam.FirstActivity;
import com.example.myapplication.exam.SecondActivity;

public class FragmentD extends Fragment {
    private Button button5;
    private Button button6;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private LinearLayout show;
    private LinearLayout linearLayout;
    private Button buttonlogout;

    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exam_three, container, false);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);
        textView1 = view.findViewById(R.id.editText);
        textView2 = view.findViewById(R.id.editText2);
        textView3 = view.findViewById(R.id.textView3);
        show = view.findViewById(R.id.show);
        linearLayout = view.findViewById(R.id.linearlayout);
        buttonlogout = view.findViewById(R.id.buttonlogout);

        // 登录
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().toString().equals("admin") && textView2.getText().toString().equals("admin")) {
                    textView3.setVisibility(View.VISIBLE);
                    show.setVisibility(View.INVISIBLE);
                    linearLayout.setVisibility(View.VISIBLE);
//                    textView1.setText("");
//                    textView2.setText("");
                    buttonlogout.setVisibility(View.VISIBLE);
                } else {
//                    linearLayout.setVisibility(View.INVISIBLE);
//                    textView1.setText("账号或密码错误, 请重试");
//                    textView2.setText("");
                    alert = null;
                    builder = new AlertDialog.Builder(getContext());
                    alert = builder
                            .setTitle("程序猿提醒您：")
                            .setMessage("账号或密码错误，请重新输入！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    textView2.setText("");
                                    textView1.setText("");
                                }
                            })
                            .create();
                    alert.show();
                }
            }
        });

        // 重置
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("");
                textView1.setText("");
            }
        });

        // 退出
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert = null;
                builder = new AlertDialog.Builder(getContext());
                alert = builder
                        .setTitle("程序猿提醒您：")
                        .setMessage("是否确定退出账号？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                textView3.setVisibility(View.INVISIBLE);
                                show.setVisibility(View.VISIBLE);
                                linearLayout.setVisibility(View.INVISIBLE);
                                textView2.setText("");
                                textView1.setText("");
                                buttonlogout.setVisibility(View.INVISIBLE);
                            }
                        })
                        .create();
                alert.show();

            }
        });

        return view;
    }

}
