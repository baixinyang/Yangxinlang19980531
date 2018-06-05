package com.bawei.yangxinlang.Activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.bawei.yangxinlang.Adapter.ViPgAdapter;
import com.bawei.yangxinlang.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private ViewGroup linlay;
    private ViewPager viewpager;
    private List<View> list = new ArrayList<>();
    private ImageButton imgbutt;
    private int[] imageview;
    private ImageView iv_point;
    private ImageView[] ivPointArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgbutt = findViewById(R.id.imgbutt);
//        initfind();
//        imgbutt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent);
                finish();
//            }
//        });
//        initViPg();
//        initPoint();




//    private void initPoint() {
//
//        ivPointArray = new ImageView[list.size()];
//        //循环新建底部圆点ImageView，将生成的ImageView保存到数组中
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            iv_point = new ImageView(this);
//            iv_point.setLayoutParams(new ViewGroup.LayoutParams(20, 20));
//            iv_point.setPadding(30, 0, 30, 0);//left,top,right,bottom
//            ivPointArray[i] = iv_point;
//            //第一个页面需要设置为选中状态，这里采用两张不同的图片
//            if (i == 0) {
//                iv_point.setBackgroundResource(R.mipmap.);
//            } else {
//                iv_point.setBackgroundResource(R.mipmap.);
//            }
//            //将数组中的ImageView加入到ViewGroup
//            linlay.addView(ivPointArray[i]);
////        }
//        }

//        private void initViPg () {
//            imageview = new int[]{R.mipmap.yin1, R.mipmap.yin2, R.mipmap.yxl};
//            list = new ArrayList<>();
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            int len = imageview.length;
//            for (int i = 0; i < len; i++) {
//                ImageView imageView = new ImageView(this);
//                imageView.setLayoutParams(params);
//                imageView.setBackgroundResource(imageview[i]);
//                list.add(imageView);
//            }
//            ViPgAdapter pgAdapter = new ViPgAdapter(list, MainActivity.this);
//            viewpager.setAdapter(pgAdapter);
//            viewpager.setOnPageChangeListener(this);
//
//        }
//

//
//        @Override
//        public void onPageScrolled ( int position, float positionOffset, int positionOffsetPixels){
//
//        }
//
//        @Override
//        public void onPageSelected ( int position){
//            int length = imageview.length;
//
//
//            //判断是否是最后一页，若是则显示按钮
//            if (position == imageview.length - 1) {
//                imgbutt.setVisibility(View.VISIBLE);
//            } else {
//                imgbutt.setVisibility(View.GONE);
//            }
//        }
//
//        @Override
//        public void onPageScrollStateChanged ( int state){
//
//        }
//    }
//        private void initfind () {
//            viewpager = findViewById(R.id.viewpager);
//            linlay = (ViewGroup) findViewById(R.id.linlay);
//
//        }
}}