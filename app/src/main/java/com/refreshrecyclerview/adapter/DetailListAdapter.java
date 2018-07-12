package com.refreshrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.refreshrecyclerview.R;
import com.refreshrecyclerview.model.ResponseDetailList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailListAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<ResponseDetailList.DataBean.ListBean> detailLists;

    public DetailListAdapter(Context context, List<ResponseDetailList.DataBean.ListBean> detailLists) {
        this.context = context;
        this.detailLists = detailLists;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, null,false);
        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder recyclerViewHolder = (ViewHolder) holder;
        ResponseDetailList.DataBean.ListBean responseDetailList = detailLists.get(position);
        if (null != recyclerViewHolder){
            recyclerViewHolder.mTvName1.setText(responseDetailList.getDate_time());
            recyclerViewHolder.mTvName2.setText(responseDetailList.getNote());
        }

    }

    @Override
    public int getItemCount() {
        return detailLists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_name1)
        TextView mTvName1 ;
        @BindView(R.id.tv_name2)
        TextView mTvName2;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
