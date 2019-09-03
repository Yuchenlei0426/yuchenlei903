package com.bawei.yuchenlei20190903.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.yuchenlei20190903.R;
import com.bawei.yuchenlei20190903.presenter.Presenter;

public  abstract class BaseActivity extends AppCompatActivity {
    /**
     * 于晨雷
     * 2019年9月3日10:25:37
     * activity 基类
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = onLayout();
        if (layout!=0) {
            setContentView(layout);
            initPresenter();
            onView();
            onData();
        }
    }
//    寻找布局
    protected abstract int onLayout();
//    Presenter层
    protected abstract Presenter initPresenter();
//    找id
    protected abstract void onView();
//    数据
    protected abstract void onData();
}
