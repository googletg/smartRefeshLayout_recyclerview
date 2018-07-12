package com.refreshrecyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.refreshrecyclerview.R;
import com.refreshrecyclerview.adapter.DetailListAdapter;
import com.refreshrecyclerview.model.ResponseDetailList;
import com.refreshrecyclerview.util.GetJson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class List1Activity extends AppCompatActivity {
    @BindView(R.id.smartrefreshlayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    DetailListAdapter mAdapter1;
    List<ResponseDetailList.DataBean.ListBean> detailLists1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);
        ButterKnife.bind(this);
        init();
    }
    private void init(){
        String jsonString = GetJson.parseJson(this,"lendrecord.json");
        ResponseDetailList responseDetailList = JSON.parseObject(jsonString,ResponseDetailList.class);
        detailLists1 = new ArrayList<>();
        detailLists1 =  responseDetailList.getData().getList();
        mAdapter1 = new DetailListAdapter(this,detailLists1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置滑动流畅性
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter1);



    }
}
