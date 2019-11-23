package com.example.hgjoke.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.hgjoke.R;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import rx.Observable;

import static com.example.hgjoke.utils.Toast.show;

/**
 * author:hm
 * Date:2019/9/28
 */
public abstract class BaseActivity extends RxAppCompatActivity {
    public final String TAG = this.getClass().getSimpleName();
    public static final List<Activity> ACTIVITIES = new ArrayList<>();
    public BaseActivity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        ACTIVITIES.add(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init(savedInstanceState);
        back();
    }


    /**
     * Rx生命周期
     */
    public <T> Observable<T> rxDestroy(Observable<T> observable) {
        return observable.compose(bindUntilEvent(ActivityEvent.DESTROY));
    }

    protected abstract int getLayoutId();

    protected abstract void init(Bundle savedInstanceState);
    public void back() {
        try {
            findViewById(R.id.iv_title_left).setOnClickListener(view -> finish());
        } catch (Exception e) {

        }
    }

    /**
     * 回首页
     */
    public void goHome() {
        for (Activity a : ACTIVITIES) {
            if (!a.getLocalClassName().equals("activitys.MainActivity")) {
                a.finish();
            }
        }
    }

    public void exit() {
        for (Activity a : ACTIVITIES)
            a.finish();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        ACTIVITIES.remove(this);
    }

    public void toast(String text) {
        show(text);
    }
    
    public void setTitleText(String title) {
        try {
            ((TextView) findViewById(R.id.tv_title_text)).setText(title);
        } catch (Exception e) {
        }
    }
}