package com.example.hgjoke.addpicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hgjoke.R;



public class GridViewAdapter extends BaseViewHolderAdapter<String, Viewholder> {
    private AddPicCallBack mAddPicCallBack;
    public GridViewAdapter(Context ctx, AddPicCallBack pAddPicCallBack) {
        super(ctx);
        this.mAddPicCallBack = pAddPicCallBack;
    }


    @Override
    public View createItemView(LayoutInflater inflater, int position) {
        return inflater.inflate(R.layout.reprot_img_item, null);
    }

    @Override
    public Viewholder createAndBindViewHolder(View view, int position) {
        ImageView iv = (ImageView) view.findViewById(R.id.report_item_iv);
        Button bt = (Button) view.findViewById(R.id.report_item_bt);
        return new Viewholder(iv, bt);
    }

    @Override
    public void bindDataToView(Viewholder holder, String pUri, final int position) {
        Glide.with(mCtx).load(pUri).error(R.drawable.add_pic_icon).into(holder.iv);
        holder.iv.setOnClickListener(null);
        holder.bt.setVisibility(View.VISIBLE);
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                mAddPicCallBack.onDeleteClick(position);
            }
        });
        if (TextUtils.isEmpty(pUri)) {
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View pView) {
                    mAddPicCallBack.onAddClick();
                }
            });
            holder.bt.setVisibility(View.INVISIBLE);
        }
    }

}


class Viewholder {
    ImageView iv;
    Button bt;

    public Viewholder(ImageView pIv, Button pBt) {
        iv = pIv;
        bt = pBt;
    }
}
