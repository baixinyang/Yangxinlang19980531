package com.bawei.yangxinlang.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ScrollView;

import com.bawei.yangxinlang.Adapter.GridViewAdapter;
import com.bawei.yangxinlang.Bean.TuBean;
import com.bawei.yangxinlang.Bean.YeBean;
import com.bawei.yangxinlang.Http.HttpConfig;
import com.bawei.yangxinlang.Http.HttpUtils;
import com.bawei.yangxinlang.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private GridView gridview;
    private PullToRefreshScrollView pulltoresc;
    private int pagertype=1;
    private int pagerpp=1;
    private String path="https://www.apiopen.top/meituApi?page="+pagerpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initfindview();
        initData();
        initPoint();

    }

    private void initPoint() {
        pulltoresc.setMode(PullToRefreshBase.Mode.BOTH);
        pulltoresc.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pagertype=1;
                pagerpp=1;
                path="https://www.apiopen.top/meituApi?page="+pagerpp;
                initData();
            }



            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                pagertype=2;
                pagerpp++;
                path="https://www.apiopen.top/meituApi?page="+pagerpp;
                initData();
            }
        });

    }
    private void initData() {
        HttpUtils httpUtils = HttpUtils.getInstance();
        httpUtils.get(HttpConfig.two);

        httpUtils.setHttpUtilsListener(new HttpUtils.HttpUtilListener() {

            @Override
            public void getSuccess(String json) {
                Gson gson = new Gson();
                TuBean tuBean = gson.fromJson(json, TuBean.class);
                List<TuBean.DataBean> data = tuBean.getData();
                GridViewAdapter viewAdapter = new GridViewAdapter(Main3Activity.this, data);
                gridview.setAdapter(viewAdapter);

            }

            @Override
            public void getError(String error) {

            }


        });


    }
    private void initfindview() {
        gridview=  findViewById(R.id.grid_view);
        pulltoresc = findViewById(R.id.pulltoresc);
    }


    }

