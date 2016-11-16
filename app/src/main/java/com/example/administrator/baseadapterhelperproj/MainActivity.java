package com.example.administrator.baseadapterhelperproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toNormal(View view){
        startActivity(new Intent(this,NormalAdapterActivity.class));
    }
    public void toQuick(View view){
        startActivity(new Intent(this,QiuckAdapterActivity.class));
    }
}
