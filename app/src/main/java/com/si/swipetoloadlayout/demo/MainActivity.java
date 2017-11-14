package com.si.swipetoloadlayout.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.si.swipetoloadlayout.listener.OnLoadMoreListener;
import com.si.swipetoloadlayout.listener.OnRefreshListener;
import com.si.swipetoloadlayout.view.SwipeToLoadLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnRefreshListener, OnLoadMoreListener {
    SwipeToLoadLayout mSwipelayout;
    ListView swipeListView;
    private ArrayList<String> mList;
    private ArrayAdapter<String> mAdapter;
    private int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipelayout = findViewById(R.id.swipeToLoadLayout);
        swipeListView = findViewById(R.id.swipe_target);


        mList = new ArrayList<>();

        mIndex = 0;
        getNextList();

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mList);

        swipeListView.setAdapter(mAdapter);

        mSwipelayout.setOnRefreshListener(this);
        mSwipelayout.setOnLoadMoreListener(this);
    }

    private void getNextList() {
        if (!mList.isEmpty()) {
            mIndex = Integer.parseInt(mList.get(mList.size() - 1)) + 1;
        }
        for (int i = 0; i < 20; i++) {
            mList.add((mIndex++) + "");
        }
    }

    private void getPreviewList() {
        mIndex = Integer.parseInt(mList.get(0));
        for (int i = 0; i < 20; i++) {
            mList.add(0, (--mIndex) + "");
        }
    }

    @Override
    public void onRefresh() {
        getPreviewList();
        mAdapter.notifyDataSetChanged();
        mSwipelayout.setRefreshing(false);
    }

    @Override
    public void onLoadMore() {
        getNextList();
        mAdapter.notifyDataSetChanged();
        mSwipelayout.setLoadingMore(false);
    }
}
