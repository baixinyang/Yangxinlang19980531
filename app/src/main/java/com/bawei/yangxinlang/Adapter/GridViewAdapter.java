package com.bawei.yangxinlang.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bawei.yangxinlang.Bean.TuBean;
import com.bawei.yangxinlang.Myapp.MyApp;
import com.bawei.yangxinlang.R;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<TuBean.DataBean> lists;

    public GridViewAdapter(Context context, List<TuBean.DataBean> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.gridview, null);
            ImageView view = convertView.findViewById(R.id.imggrid);
            viewHodler = new ViewHodler(view);
            convertView.setTag(viewHodler);
        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }
        String url = lists.get(position).getUrl();
        ImageLoader.getInstance().displayImage(url, viewHodler.getView(), MyApp.getOptions());
        return convertView;
    }
    class ViewHodler{
        ImageView view;

        public ViewHodler(ImageView view) {
            this.view = view;
        }

        public void setView(ImageView view) {
            this.view = view;
        }

        public ImageView getView() {
            return view;
        }
    }
}
