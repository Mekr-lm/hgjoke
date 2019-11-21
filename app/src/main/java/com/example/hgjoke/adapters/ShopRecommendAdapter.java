package com.example.hgjoke.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hgjoke.R;
import com.example.hgjoke.activity.BaseActivity;
import com.example.hgjoke.entitys.ShopInfo;
import com.example.hgjoke.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopRecommendAdapter extends RecyclerView.Adapter<ShopRecommendAdapter.TextViewHolder> {
    private List<ShopInfo> list;
    private Context mContext;
    private BaseFragment mFragment;
    private BaseActivity mActivity;
    public ShopRecommendAdapter(Context mContext, BaseFragment fragment) {
        this.mContext = mContext;
        this.mFragment = fragment;

    }

    public void setmList(List<ShopInfo> list){
        this.list = list;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop_recommend, parent, false));
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder,int position) {
        holder.showData(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_icon1)
        TextView textView1;
        @BindView(R.id.txt_icon2)
        TextView textView2;
        public TextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void showData(ShopInfo data){
            textView1.setText(data.getName());
            textView2.setText(data.getContent());
        }
    }
}