package com.rt3.rtsystem.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.rt3.rtsystem.MyApplication;

/**
 * Created by RT3
 * on 2017/8/2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        mContext = MyApplication.getContext();
        setActionBarState();
        initView();
        initData();
        initListener();
    }

    /**
     * 设置actionbar的显示状态
     */
    private void setActionBarState() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar.isShowing()) {
            actionBar.hide();
        }
    }

    /**
     * 返回activity界面的布局文件
     *
     * @return
     */
    public abstract int getLayoutResId();

    /**
     * 初始化子控件
     *
     * @return
     */
    protected abstract void initView();

    /**
     * 初始化数据
     *
     * @return
     */
    protected abstract void initData();

    /**
     * 初始化监听器
     *
     * @return
     */
    protected abstract void initListener();


}
