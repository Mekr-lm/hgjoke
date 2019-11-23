package com.example.hgjoke.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.hgjoke.R;
import com.example.hgjoke.addpicview.AddPicView;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;

import java.util.ArrayList;

import butterknife.BindView;

public class ClassPublishActivity extends BaseActivity {
    @BindView(R.id.add_pic_view)
    AddPicView mApv;
    private final int GET_ALBUM_1 = 110;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_class_publish;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitleText("开发团队入驻");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1004 && requestCode == GET_ALBUM_1 && null != data) {
            ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
            for (ImageItem img : images) {
                mApv.addPicture(img.path);
            }
        }
    }
}
