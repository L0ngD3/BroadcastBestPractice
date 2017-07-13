package com.example.a13522.xiaxian;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * 作为所有活动的父类
 */

public class BaseActivity extends AppCompatActivity {
    private ForceOffLine receive;

    //创建活动
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("aaa","onCreate");
        ActivityCollector.addActivity(this);
    }

    //创建广播
    protected void onResume() {
        super.onResume();
        Log.d("aaa","onResume");
        //广播
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.a13522.xiaxian.FORCE_OFFLINE");
        receive = new ForceOffLine();
        registerReceiver(receive,intentFilter);

    }
//销毁登录那个活动
    protected void onPause() {
        super.onPause();
        Log.d("aaa","onPause");
        if (receive!=null){
            unregisterReceiver(receive);
            receive = null;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("aaa","onDestroy");
        ActivityCollector.removeActivity(this);
    }


    //此方法用来跳出弹窗，和实现跳转的
    class ForceOffLine extends BroadcastReceiver{
        public void onReceive(final Context context, final Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("警告");
            builder.setMessage("你的账户多地登录，请修改密码重新登录");
            builder.setCancelable(false);
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {  //跳转到登录界面

                    ActivityCollector.finishAll();//销毁所有活动
                    Intent intent= new Intent(context,LoginActivity.class);
                    //重新启动活动
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }
}
