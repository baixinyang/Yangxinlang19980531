package com.bawei.yangxinlang.Activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.yangxinlang.R;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawer_layout;
    private TextView t1;
    private TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        find();


    }

    private void find() {
        drawer_layout = findViewById(R.id.drawer_layout);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.t1:
                Intent intent = new Intent(Main4Activity.this, Main2Activity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.t2:
                Intent intent2 = new Intent(Main4Activity.this, Main3Activity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }


}
