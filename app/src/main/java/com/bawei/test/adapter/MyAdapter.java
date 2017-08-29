package com.bawei.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.test.R;
import com.bawei.test.bean.News;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by asus on 2017/8/29.
 */

public class MyAdapter extends BaseAdapter {
    private final Context context;
    private final List<News.ResultBean.DataBean> list;

    public MyAdapter(Context context, List<News.ResultBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
if(view==null)
{
    view=View.inflate(context, R.layout.item,null);
}
        TextView tv_title=view.findViewById(R.id.tv_title);
        ImageView iv_icon=view.findViewById(R.id.iv_icon);
        tv_title.setText(list.get(i).getTitle());
        ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),iv_icon);
        return view;
    }
}
