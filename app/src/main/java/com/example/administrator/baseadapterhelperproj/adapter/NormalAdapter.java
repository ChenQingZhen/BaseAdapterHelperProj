package com.example.administrator.baseadapterhelperproj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.baseadapterhelperproj.R;
import com.example.administrator.baseadapterhelperproj.beans.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright ©  bookegou.com
 * Created by Administrator on 2016/11/16.
 */
public class NormalAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<UserBean> mItemList;

    public NormalAdapter(Context context,List<UserBean> userList){
        mContext=context;
        mLayoutInflater=LayoutInflater.from(context);
        mItemList=userList;
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public UserBean getItem(int i) {
        return mItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        if(view==null){
            view=mLayoutInflater.inflate(R.layout.item_user_list,viewGroup,false);
            vh=new ViewHolder();
            vh.avaterIv= (ImageView) view.findViewById(R.id.iv_avater);
            vh.nameTv= (TextView) view.findViewById(R.id.tv_name);
            vh.ageTv= (TextView) view.findViewById(R.id.tv_age);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }
        UserBean user=getItem(i);
        vh.avaterIv.setImageResource(user.avater);
        vh.nameTv.setText(user.name);
        vh.ageTv.setText(String.valueOf(user.age));
        return view;
    }
    static class ViewHolder{
        ImageView avaterIv;
        TextView nameTv;
        TextView ageTv;
    }
}
