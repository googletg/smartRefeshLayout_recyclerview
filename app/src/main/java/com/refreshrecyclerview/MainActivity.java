package com.refreshrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.refreshrecyclerview.activity.List1Activity;
import com.refreshrecyclerview.activity.List2Activity;
import com.refreshrecyclerview.activity.List3Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.tv_list1)
    TextView mTvList1;
    @BindView(R.id.tv_list2)
    TextView mTvList2;
    @BindView(R.id.tv_list3)
    TextView mTvList3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }
    private void init(){
        initListener();
    }

    private void initListener(){
        mTvList1.setOnClickListener(this);
        mTvList2.setOnClickListener(this);
        mTvList3.setOnClickListener(this);
    }

    @OnClick
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tv_list1:
                Intent intent = new Intent(this , List1Activity.class);
                startActivity(intent);
                break;
            case R.id.tv_list2:
                Intent intent1 = new Intent(this, List2Activity.class);
                startActivity(intent1);
                break;

            case R.id.tv_list3:
                Intent intent2 = new Intent(this, List3Activity.class);
                startActivity(intent2);
                break;
        }

    }
}
