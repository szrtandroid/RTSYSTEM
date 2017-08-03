package com.rt3.rtsystem.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rt3.rtsystem.R;
import com.rt3.rtsystem.bean.ItemBean;

import java.util.List;

/**
 * Created by RT3
 * on 2017/8/1.
 */

public class GridViewAdapter extends BaseAdapter {
    private List<ItemBean> list;
    private Context context;

    public GridViewAdapter(Context context, List<ItemBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder=new ViewHolder();
            convertView = View.inflate(context, R.layout.item_gridview, null);
            viewHolder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_count= (TextView) convertView.findViewById(R.id.tv_count);
            convertView.setTag(viewHolder);
        } else {

            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_name.setText(list.get(position).getName());
        viewHolder.tv_count.setText(list.get(position).getCount());
        return convertView;
    }

    static class ViewHolder {
        TextView tv_name;
        TextView tv_count;
    }
}
