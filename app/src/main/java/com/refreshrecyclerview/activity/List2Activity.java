package com.refreshrecyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.refreshrecyclerview.R;
import com.refreshrecyclerview.adapter.DetailListAdapter;
import com.refreshrecyclerview.model.ResponseDetailList;
import com.refreshrecyclerview.util.GetJson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class List2Activity extends AppCompatActivity {
    @BindView(R.id.smartrefreshlayout2)
    SmartRefreshLayout smartRefreshLayout2;
    @BindView(R.id.recyclerview2)
    RecyclerView recyclerView2;
    DetailListAdapter mAdapter;

    List<ResponseDetailList.DataBean.ListBean> listBeanList;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
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
          linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setAdapter(mAdapter);
    }

}
