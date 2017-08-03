package com.rt3.rtsystem.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rt3.rtsystem.R;
import com.rt3.rtsystem.adapter.GridViewAdapter;
import com.rt3.rtsystem.bean.ItemBean;
import com.rt3.rtsystem.bean.MonthCollectPlasma;
import com.rt3.rtsystem.constant.Constants;
import com.rt3.rtsystem.interfaces.OnDialogClickListener;
import com.rt3.rtsystem.view.ConfirmDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends BaseActivity {


    private GridView mGd_view;
    private List<ItemBean> mList;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mGd_view = (GridView) findViewById(R.id.gd_view);

    }

    @Override
    protected void initData() {
        //准备数据集
        mList = new ArrayList<>();

        ItemBean bean = new ItemBean("预约人数", "500");
        mList.add(bean);
        ItemBean bean1 = new ItemBean("报名人数", "600");
        mList.add(bean1);
        ItemBean bean2 = new ItemBean("新接档人数", "1100");
        mList.add(bean2);
        ItemBean bean3 = new ItemBean("不合格人数", "800");
        mList.add(bean3);
        ItemBean bean4 = new ItemBean("采浆袋数", "4500");
        mList.add(bean4);

        GridViewAdapter adapter = new GridViewAdapter(this, mList);
        mGd_view.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

        mGd_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemBean itemBean = mList.get(position);

                Intent intent = new Intent(MainActivity.this, LineChartActivity.class);
                intent.putExtra("bean", itemBean);
                startActivity(intent);

            }
        });
    }

    /**
     * 监听返回键弹出对话框，退出程序
     *
     * @param keyCode
     * @param event
     * @return
     */

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_HOME) {
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            ConfirmDialog dialog = new ConfirmDialog(this, "温馨提示", "确定退出系统吗？", new OnDialogClickListener() {
                @Override
                public void onConfirm(Dialog dialog) {
                    finish();
                }

                @Override
                public void onCancel(Dialog dialog) {
                    dialog.dismiss();
                }
            });
            dialog.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
