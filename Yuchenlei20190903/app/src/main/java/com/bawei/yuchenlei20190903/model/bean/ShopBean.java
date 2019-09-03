package com.bawei.yuchenlei20190903.model.bean;

import java.util.ArrayList;

public class ShopBean {
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public class Data {
        private String goods_name;
        private String goods_thumb;
        private String currency_price;

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public String getCurrency_price() {
            return currency_price;
        }

        public void setCurrency_price(String currency_price) {
            this.currency_price = currency_price;
        }
    }
}
