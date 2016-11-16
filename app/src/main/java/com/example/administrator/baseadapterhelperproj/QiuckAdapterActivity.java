package com.example.administrator.baseadapterhelperproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.administrator.baseadapterhelperproj.adapter.BaseAdapterHelper;
import com.example.administrator.baseadapterhelperproj.adapter.NormalAdapter;
import com.example.administrator.baseadapterhelperproj.adapter.QuickAdapter;
import com.example.administrator.baseadapterhelperproj.beans.UserBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QiuckAdapterActivity extends AppCompatActivity {
    private static int[] mImgs={R.mipmap.cat,R.mipmap.cat_,R.mipmap.dog,R.mipmap.dogs};
    private static int[] mAges={18,19,20,21,22,23,24,25,26,27,28,29,30};
    private List<UserBean> mUserList=new ArrayList<>();
    private ListView mQuickLv;
    private QuickAdapter<UserBean> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qiuck_adapter);
        initView();
        initData();
    }

    private void initData() {
        UserBean user;
        for(int i=0;i<1000;i++){
            user=new UserBean();
            user.id=i;
            user.avater= mImgs[new Random().nextInt(4)];
            user.age=mAges[new Random().nextInt(mAges.length)];
            mUserList.add(user);
        }
        long begin= System.currentTimeMillis();
        mAdapter=new QuickAdapter<UserBean>(this,R.layout.item_user_list,mUserList) {
            @Override
            protected void convert(BaseAdapterHelper helper, UserBean item) {
                helper.setImageResource(R.id.iv_avater,item.avater);
                helper.setText(R.id.tv_name,item.name);
                helper.setText(R.id.tv_age,String.valueOf(item.age));
            }
        };
        mQuickLv.setAdapter(mAdapter);
        long end=System.currentTimeMillis();
        Log.d("por_test","quick[1000]:"+(end-begin));
    }

    private void initView() {
        mQuickLv= (ListView) findViewById(R.id.lv_quick);
        setTitle("快速");
    }
}
