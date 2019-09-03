package com.bawei.yuchenlei20190903.utils.nets;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.yuchenlei20190903.utils.ap.App;

import java.net.URLEncoder;

/**
 * 于晨雷
 * 2019-9-3 09:44:30
 * 网络封装
 */
public class NetUtils {
    private static final NetUtils ourInstance = new NetUtils();
    private SharedPreferences sharedPreferences;

    public static NetUtils getInstance() {
        return ourInstance;
    }

    private NetUtils() {
    }

    public  interface mCallBack{
        void onSec(Object data);
        void onEro(String mes);
    }
    public boolean isNetsWork(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected();
        }
        return false;
    }
//Get网络请求
   public void doGet(String url, final mCallBack mCallBack){
       boolean netsWork = isNetsWork(App.context);
       if (netsWork) {
           RequestQueue requestQueue = Volley.newRequestQueue(App.context);
           StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
               @Override
               public void onResponse(String response) {
                   if (mCallBack!=null) {
                       mCallBack.onSec(response);
/*                       sharedPreferences = App.context.getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE);
                       sharedPreferences.getString("data",response);*/
                   }
               }
           }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
                   if (mCallBack!=null) {
                       mCallBack.onEro(error.toString());
                   }
               }
           });
           requestQueue.add(stringRequest);

       }else{
           Toast.makeText(App.context, "无网络！！！", Toast.LENGTH_SHORT).show();
       }

    }
}
