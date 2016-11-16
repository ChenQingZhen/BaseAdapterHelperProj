package com.example.administrator.baseadapterhelperproj;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.administrator.baseadapterhelperproj.adapter.NormalAdapter;
import com.example.administrator.baseadapterhelperproj.beans.UserBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NormalAdapterActivity extends AppCompatActivity {
    private static int[] mImgs={R.mipmap.cat,R.mipmap.cat_,R.mipmap.dog,R.mipmap.dogs};
    private static int[] mAges={18,19,20,21,22,23,24,25,26,27,28,29,30};
    private List<UserBean> mUserList=new ArrayList<>();
    private ListView mNormalLv;
    private NormalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_adapter);
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
        mAdapter=new NormalAdapter(this,mUserList);
        mNormalLv.setAdapter(mAdapter);
        long end=System.currentTimeMillis();
        Log.d("por_test","normal[1000]:"+(end-begin));
    }

    private void initView() {
      mNormalLv= (ListView) findViewById(R.id.lv_normal);
        setTitle("普通");
    }
}
