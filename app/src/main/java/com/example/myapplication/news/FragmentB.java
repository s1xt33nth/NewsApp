package com.example.myapplication.news;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.exam.AdapterActivity;
import com.example.myapplication.exam.MyTestAdapter;
import com.example.myapplication.exam.ShowActivity;
import com.example.myapplication.exam.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FragmentB extends Fragment {

    private ListView listView;
    private MyTestAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_adapter,container,false);
        initView(view);
        return view;
    }

    private void initView(View view){
        listView = view.findViewById(R.id.listView);
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setAge((int) ( 20 + (Math.random()) * 10));
            student.setName(UUID.randomUUID().toString().substring(0, 8).replace("-", "").toUpperCase());
            student.setPhoto(R.mipmap.img);
            studentList.add(student);
        }

        adapter = new MyTestAdapter(studentList, getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listViewParent = (ListView) parent;
                Student student = (Student) listViewParent.getItemAtPosition(position);
                int photo = student.getPhoto();
                String name = student.getName();
                int age = student.getAge();

                Intent intent = new Intent(getActivity(), ShowActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("photo", photo);
                bundle.putString("name", name);
                bundle.putInt("age", age);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
