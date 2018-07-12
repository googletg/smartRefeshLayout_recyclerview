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

public class List3Activity extends AppCompatActivity {
    @BindView(R.id.smartrefreshlayout2)
    SmartRefreshLayout smartRefreshLayout2;
    @BindView(R.id.recyclerview3)
    RecyclerView recyclerView3;
    DetailListAdapter mAdapter;

    List<ResponseDetailList.DataBean.ListBean> listBeanList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        String jsonString = GetJson.parseJson(this,"lendrecord.json");
//        ResponseDetailList responseDetailList = (ResponseDetailList) JSONObject.parse(jsonString);
        ResponseDetailList responseDetailList = JSON.parseObject(jsonString,ResponseDetailList.class);
        listBeanList = new ArrayList<>();
        listBeanList =  responseDetailList.getData().getList();
        mAdapter = new DetailListAdapter(this , listBeanList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
       /* linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setNestedScrollingEnabled(false);*/
        recyclerView3.setLayoutManager(linearLayoutManager);
        recyclerView3.setAdapter(mAdapter);
    }
}
