package com.example.myapplication.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class MyListViewAdapter extends BaseAdapter {

    private List<Data> data;
    private Context context;

    public MyListViewAdapter() {
    }

    public MyListViewAdapter(List<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ViewHolder用于对控件的实例进行缓存
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.image1 = convertView.findViewById(R.id.image1);
            viewHolder.txt_item_title = convertView.findViewById(R.id.txt_item_title);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.image1.setImageResource(data.get(position).getNew_icon());
        viewHolder.txt_item_title.setText(data.get(position).getNew_title());
        return convertView;
    }

    private class ViewHolder{
        TextView txt_item_title;
        ImageView image1;
    }
}
