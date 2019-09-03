package com.bawei.yuchenlei20190903.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bawei.yuchenlei20190903.R;
import com.bawei.yuchenlei20190903.base.BaseActivity;
import com.bawei.yuchenlei20190903.base.BasePresenter;
import com.bawei.yuchenlei20190903.contract.Contract;
import com.bawei.yuchenlei20190903.model.adatper.PullMadatper;
import com.bawei.yuchenlei20190903.model.bean.ShopBean;
import com.bawei.yuchenlei20190903.presenter.Presenter;
import com.bawei.yuchenlei20190903.utils.ap.Api;
import com.bwei.xlistview.XlistView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements Contract.view{
    private static final String TAG = "MainActivity";
    private XlistView pull;

    @Override
    protected int onLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter(this);
    }


    @Override
    protected void onView() {
        pull = (XlistView) findViewById(R.id.pull);
    }

    @Override
    protected void onData() {
        final Contract.Presenter presenter = (Contract.Presenter) initPresenter();
        presenter.doGet(Api.ONE_PATH);
        pull.setPullLoadEnable(true);
        pull.setXListViewListener(new XlistView.IXListViewListener() {
            @Override
            public void onRefresh() {
                presenter.doGet(Api.TWO_PATH);
                pull.stopRefresh(5000);

            }

            @Override
            public void onLoadMore() {
                presenter.doGet(Api.THERE_PATH);
                pull.stopLoadMore(5000);
            }
        });
    }

    @Override
    public void noSec(Object data) {
        String json = data.toString();
        Log.i(TAG, "noSec: "+json);
        Gson gson = new Gson();
        ShopBean shopBean = gson.fromJson(json, ShopBean.class);
        ArrayList<ShopBean.Data> data1 = shopBean.getData();
        PullMadatper pullMadatper = new PullMadatper(MainActivity.this,data1);
        pull.setAdapter(pullMadatper);


    }

    @Override
    public void onEro(String mes) {
        Log.i(TAG, "onEro: "+mes);
    }
}
