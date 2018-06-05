package com.bawei.yangxinlang.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yangxinlang.Activity.Main2Activity;
import com.bawei.yangxinlang.Bean.YeBean;
import com.bawei.yangxinlang.Myapp.MyApp;
import com.bawei.yangxinlang.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ListviewAdapter extends BaseAdapter {
    private List<YeBean.DataBean> list = new ArrayList<>();
    private Context context;

    public ListviewAdapter(List<YeBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        String type = list.get(position).getType();
        if (type.equals("41")) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                BigViewHolder bigViewHolder;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.bigitem, null);
                    ImageView img = convertView.findViewById(R.id.img);
                    TextView text01 = convertView.findViewById(R.id.text01);
                    TextView text02 = convertView.findViewById(R.id.text02);
                    TextView text03 = convertView.findViewById(R.id.text03);
                    bigViewHolder = new BigViewHolder(text01, text02, text03, img);
                convertView.setTag(bigViewHolder);
        } else {
            bigViewHolder = (BigViewHolder) convertView.getTag();
        }
                YeBean.DataBean dataBean = list.get(position);
                String name = dataBean.getName();
                String passtime = dataBean.getPasstime();
                String text = dataBean.getText();
                String profile_image = dataBean.getProfile_image();
                ImageLoader.getInstance().displayImage(profile_image, bigViewHolder.getImg(), MyApp.getOptions());
                bigViewHolder.getText01().setText(name);
                bigViewHolder.getText02().setText(passtime);
                bigViewHolder.getText03().setText(text);
                break;
            case 1:
                SamllViewHolder samllViewHolder;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.samllitem, null);
                    ImageView img010 = convertView.findViewById(R.id.img010);
                    TextView text001 = convertView.findViewById(R.id.text001);
                    TextView text002 = convertView.findViewById(R.id.text002);
                    ImageView img001 = convertView.findViewById(R.id.img001);
                    samllViewHolder = new SamllViewHolder(text001, text002, img010, img001);
                    convertView.setTag(samllViewHolder);
                } else {
                    samllViewHolder = (SamllViewHolder) convertView.getTag();
                }
                YeBean.DataBean dataBean1 = list.get(position);
                String name1 = dataBean1.getName();
                String passtime1 = dataBean1.getPasstime();

                String profile_image1 = dataBean1.getProfile_image();
                ImageLoader.getInstance().displayImage(profile_image1, samllViewHolder.getImg010(), MyApp.getOptions());
                samllViewHolder.getText001().setText(name1);
                samllViewHolder.getText002().setText(passtime1);
                ImageLoader.getInstance().displayImage(profile_image1, samllViewHolder.getImg001(), MyApp.getOptions());
                break;
        }
        return convertView;
    }

    class BigViewHolder {
        TextView text01;
        TextView text02;
        TextView text03;
        ImageView img;

        public BigViewHolder(TextView text01, TextView text02, TextView text03, ImageView img) {
            this.text01 = text01;
            this.text02 = text02;
            this.text03 = text03;
            this.img = img;
        }

        public void setText01(TextView text01) {
            this.text01 = text01;
        }

        public void setText02(TextView text02) {
            this.text02 = text02;
        }

        public void setText03(TextView text03) {
            this.text03 = text03;
        }

        public void setImg(ImageView img) {
            this.img = img;
        }

        public TextView getText01() {
            return text01;
        }

        public TextView getText02() {
            return text02;
        }

        public TextView getText03() {
            return text03;
        }

        public ImageView getImg() {
            return img;
        }
    }
    class SamllViewHolder{
        TextView text001;
        TextView text002;
        ImageView img010;
        ImageView img001;

        public SamllViewHolder(TextView text001, TextView text002, ImageView img010, ImageView img001) {
            this.text001 = text001;
            this.text002 = text002;
            this.img010 = img010;
            this.img001 = img001;
        }

        public void setText001(TextView text001) {
            this.text001 = text001;
        }

        public void setText002(TextView text002) {
            this.text002 = text002;
        }

        public void setImg010(ImageView img010) {
            this.img010 = img010;
        }

        public void setImg001(ImageView img001) {
            this.img001 = img001;
        }

        public TextView getText001() {
            return text001;
        }

        public TextView getText002() {
            return text002;
        }

        public ImageView getImg010() {
            return img010;
        }

        public ImageView getImg001() {
            return img001;
        }
    }
}
