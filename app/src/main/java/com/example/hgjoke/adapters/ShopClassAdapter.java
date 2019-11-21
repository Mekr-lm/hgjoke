package com.example.hgjoke.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hgjoke.R;
import com.example.hgjoke.activity.ShopDetailsActivity;
import com.example.hgjoke.entitys.ShopListInfo;
import com.example.hgjoke.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopClassAdapter extends RecyclerView.Adapter<ShopClassAdapter.ViewHolder>  {
    private Context mContext;
    private BaseFragment mFragment;
    private List<ShopListInfo> mList;
    public ShopClassAdapter(Context mContext, BaseFragment mFragment) {
        this.mContext = mContext;
        this.mFragment = mFragment;
    }

    public void setmList(List<ShopListInfo> mList) {
        this.mList = mList;
    }

    @Override
    public ShopClassAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShopClassAdapter.ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_shop, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.showData(mList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ShopDetailsActivity.class);
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
        @BindView(R.id.tv_shop_title)
        TextView title;
        @BindView(R.id.tv_content)
        TextView content;
        @BindView(R.id.price)
        TextView price;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void showData(ShopListInfo data) {
            title.setText(data.getTitle());
            content.setText(data.getContent());
            price.setText(data.getPrice());

        }

    }
}
