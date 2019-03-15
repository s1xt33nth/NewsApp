package com.example.myapplication.exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class MyTestAdapter extends BaseAdapter {

    private List<Student> studentList;
    private Context context;

    public MyTestAdapter() {
    }

    public MyTestAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return studentList == null ? 0 : studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_student_item, parent, false);
        ImageView imageView = convertView.findViewById(R.id.image_photo);
        TextView textView = convertView.findViewById(R.id.name);
        TextView textView1 = convertView.findViewById(R.id.age);
        imageView.setImageResource(studentList.get(position).getPhoto());
        textView.setText("Name: " + studentList.get(position).getName());
        textView1.setText("Age: " + studentList.get(position).getAge());
        return convertView;

    }

}
