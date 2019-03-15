package com.example.myapplication.exam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterActivity extends AppCompatActivity {

    private ListView listView;
    private MyTestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        listView = findViewById(R.id.listView);
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(10 + i);
            student.setName("Name: 00" + i);
            student.setPhoto(R.mipmap.ic_launcher);
            studentList.add(student);
        }

        adapter = new MyTestAdapter(studentList, AdapterActivity.this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listViewParent = (ListView) parent;
                Student student = (Student) listViewParent.getItemAtPosition(position);
                int photo = student.getPhoto();
                String name = student.getName();
                int age = student.getAge();

                Intent intent = new Intent(AdapterActivity.this, ShowActivity.class);
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
