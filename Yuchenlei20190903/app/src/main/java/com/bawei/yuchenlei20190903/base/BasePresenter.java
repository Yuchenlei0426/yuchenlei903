package com.bawei.yuchenlei20190903.base;

public class BasePresenter {
    public BaseView baseView;

    public BasePresenter(BaseView baseView) {
        this.baseView = baseView;
    }
    public void onDestroy(){
        if (baseView!=null) {
            baseView=null;
        }
    }
}
