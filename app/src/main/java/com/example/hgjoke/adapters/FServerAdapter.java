package com.example.hgjoke.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hgjoke.R;
import com.example.hgjoke.activity.ServerDetailsActivity;
import com.example.hgjoke.entitys.FServerInfo;
import com.example.hgjoke.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FServerAdapter extends RecyclerView.Adapter<FServerAdapter.ViewHolder>  {
    private Context mContext;
    private BaseFragment mFragment;
    private List<FServerInfo> mList;
    public FServerAdapter(Context mContext, BaseFragment mFragment) {
        this.mContext = mContext;
        this.mFragment = mFragment;
    }

    public void setmList(List<FServerInfo> mList) {
        this.mList = mList;
    }

    @Override
    public FServerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FServerAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_fserver, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.showData(mList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ServerDetailsActivity.class);
                intent.putExtra("data",mList.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.context)
        TextView context;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.ly_title)
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void showData(FServerInfo data) {
            context.setText(data.getContext());
            price.setText("￥"+data.getPrice());
            title.setText(data.getTitle());
        }

    }
}
