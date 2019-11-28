package com.example.hgjoke.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hgjoke.R;
import com.example.hgjoke.activity.MessageDetailsActivity;
import com.example.hgjoke.entitys.CarInfo;
import com.example.hgjoke.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopCarAdapter extends RecyclerView.Adapter<ShopCarAdapter.ViewHolder>  {
    private Context mContext;
    private BaseFragment mFragment;
    private List<CarInfo> mList;
    public ShopCarAdapter(Context mContext, BaseFragment mFragment) {
        this.mContext = mContext;
        this.mFragment = mFragment;
    }

    public void setmList(List<CarInfo> mList) {
        this.mList = mList;
    }

    @Override
    public ShopCarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShopCarAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_car, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.showData(mList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MessageDetailsActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.tv_content)
        TextView content;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void showData(CarInfo data) {
            name.setText(data.getName());
            title.setText(data.getTitle());
            content.setText(data.getContent());
        }

    }
}
