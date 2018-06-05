package com.bawei.yangxinlang.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;


import com.bawei.yangxinlang.Adapter.ListviewAdapter;
import com.bawei.yangxinlang.Bean.YeBean;
import com.bawei.yangxinlang.Http.HttpConfig;
import com.bawei.yangxinlang.Http.HttpUtils;
import com.bawei.yangxinlang.Http.HttpUtils.HttpUtilListener;
import com.bawei.yangxinlang.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.List;

import static java.security.AccessController.getContext;

public class Main2Activity  extends Activity {

    private ListView listview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initfindview();
        getDataFromNet();
    }



    private void getDataFromNet() {
        HttpUtils httpUtils = HttpUtils.getInstance();
        httpUtils.get(HttpConfig.one_url);

        httpUtils.setHttpUtilsListener(new HttpUtilListener() {

            @Override
            public void getSuccess(String json) {
                Gson gson = new Gson();
                YeBean yeBean = gson.fromJson(json, YeBean.class);
                List<YeBean.DataBean> list = yeBean.getData();
                ListviewAdapter adapter = new ListviewAdapter(list, Main2Activity.this);
                listview.setAdapter(adapter);
            }

            @Override
            public void getError(String error) {

            }


        });
    }
    private void initfindview() {
        listview=  findViewById(R.id.list_view);

    }
}
