package com.example.myapplication.exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Bundle bundle = getIntent().getExtras();
        int photo = bundle.getInt("photo");
        String name = bundle.getString("name");
        int age = bundle.getInt("age");

        ImageView imageView = this.findViewById(R.id.image_photo1);
        TextView textView = this.findViewById(R.id.name1);
        TextView textView1 = this.findViewById(R.id.age1);
        imageView.setImageResource(photo);
        textView.setText("Name: " + name);
        textView1.setText("Age: " + age);
    }
}
