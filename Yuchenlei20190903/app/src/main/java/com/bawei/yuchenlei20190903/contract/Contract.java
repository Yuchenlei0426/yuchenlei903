package com.bawei.yuchenlei20190903.contract;

import com.bawei.yuchenlei20190903.base.BasePresenter;
import com.bawei.yuchenlei20190903.base.BaseView;

/**
 * 于晨雷
 * 2019-9-3 09:45:07
 * 契约类
 */
public interface Contract {
     interface view extends BaseView{
     }
     abstract class  Presenter extends BasePresenter{
         public Presenter(BaseView baseView) {
             super(baseView);
         }
         public  abstract void doGet(String url);
     }

}
