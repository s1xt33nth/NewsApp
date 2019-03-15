package com.example.myapplication.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class NewListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<Data> datas;
    private ListView list_news;

    private FragmentManager fragmentManager;

    public NewListFragment(FragmentManager fragmentManager, ArrayList<Data> datas) {
        this.fragmentManager = fragmentManager;
        this.datas = datas;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_newlist, container, false);

        list_news = view.findViewById(R.id.list_news);
        list_news.setDividerHeight(5);
        MyListViewAdapter myListViewAdapter = new MyListViewAdapter(datas, getActivity());
        list_news.setAdapter(myListViewAdapter);
        list_news.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NewContentFragment newContentFragment = new NewContentFragment();
        Bundle bd = new Bundle();
        bd.putString("content", datas.get(position).getNew_content());
        newContentFragment.setArguments(bd);

        // 加上Fragment替换动画
        fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit, R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        fragmentTransaction.replace(R.id.frameLayout2, newContentFragment);

        // 调用addToBackStack将Fragment添加到栈中
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
