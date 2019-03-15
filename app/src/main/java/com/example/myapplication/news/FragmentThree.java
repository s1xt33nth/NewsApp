package com.example.myapplication.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.exam.FirstActivity;
import com.example.myapplication.news.weather.CONFIG;
import com.example.myapplication.news.weather.JsonBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;

public class FragmentThree extends Fragment {

    private TextView textView0;
    private TextView textView1;
    private TextView textView2;
    private EditText editText;
    private Button button;

    String url = CONFIG.API.URL;
    String cityname = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_view_three, container, false);
        textView0 = view.findViewById(R.id.text_view0);
        textView1 = view.findViewById(R.id.text_view1);
        textView2 = view.findViewById(R.id.text_view2);
        editText = view.findViewById(R.id.edit_text);
        button = view.findViewById(R.id.confirm_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityname = editText.getText().toString();
                if ("".equals(cityname)) {
                    textView0.setText("请输入正确格式的城市名");
                    textView1.setText("");
                    textView2.setText("");
                } else {
                    initData(url + "&cityname=" + cityname);
                }
            }
        });

        initData(url + "&cityname=1419");

        return view;
    }

    private void initData(String url) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);


        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        textView1.setText("请求失败");
                        textView1.setText("");
                        textView2.setText("");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        processData(response);
                    }
                });
    }

    private void processData(String json) {
        JsonBean jsonBean = JSON.parseObject(json, JsonBean.class);
        String city = jsonBean.getResult().getToday().getCity();
        String temperature = jsonBean.getResult().getToday().getTemperature();
        String weather = jsonBean.getResult().getToday().getWeather();
        String advice = jsonBean.getResult().getToday().getDressing_advice();
        textView0.setText("所在城市：" + city);
        textView1.setText("今日天气: " + temperature + " " + weather);
        textView2.setText("穿衣建议: " + advice);
    }
}
