package com.bawei.yuchenlei20190903.presenter;

import com.bawei.yuchenlei20190903.base.BaseView;
import com.bawei.yuchenlei20190903.contract.Contract;
import com.bawei.yuchenlei20190903.utils.nets.NetUtils;

public class Presenter extends Contract.Presenter {
    public Presenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public void doGet(String url) {
        NetUtils.getInstance().doGet(url, new NetUtils.mCallBack() {
            @Override
            public void onSec(Object data) {
                if (baseView!=null) {
                    baseView.noSec(data);
                }
            }

            @Override
            public void onEro(String mes) {
                if (baseView!=null) {
                    baseView.onEro(mes);
                }
            }
        });
    }
}
