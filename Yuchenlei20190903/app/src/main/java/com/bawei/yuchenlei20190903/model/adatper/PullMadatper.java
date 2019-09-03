package com.bawei.yuchenlei20190903.model.adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yuchenlei20190903.R;
import com.bawei.yuchenlei20190903.model.MainActivity;
import com.bawei.yuchenlei20190903.model.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PullMadatper extends BaseAdapter {
    Context context;
    ArrayList<ShopBean.Data> data1;

    public PullMadatper(Context context, ArrayList<ShopBean.Data> data1) {
        this.context = context;
        this.data1 = data1;
    }

    @Override
    public int getCount() {
        return data1.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      Viewhander viewhander;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.itme, null);
            viewhander = new Viewhander();
            viewhander.tv_goods_name= convertView.findViewById(R.id.tv_goods_name);
            viewhander.tv_currency_price= convertView.findViewById(R.id.tv_currency_price);
            viewhander.iv_goods_thumb = convertView.findViewById(R.id.iv_goods_thumb);
            convertView.setTag(viewhander);
        }else {
            viewhander= (Viewhander) convertView.getTag();
        }
        viewhander.tv_goods_name.setText(data1.get(position).getGoods_name());
        viewhander.tv_currency_price.setText(data1.get(position).getCurrency_price());
        Glide.with(context).load(data1.get(position).getGoods_thumb()).into(viewhander.iv_goods_thumb);
        return convertView;
    }

    private class Viewhander {
        ImageView iv_goods_thumb;
        TextView tv_goods_name,tv_currency_price;
    }
}
