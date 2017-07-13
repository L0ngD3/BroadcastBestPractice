package com.example.a13522.xiaxian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      Button offline = (Button) findViewById(R.id.offLine);
        offline.setOnClickListener(new View.OnClickListener() {
           //点击按钮 点击后发出一条广播
            public void onClick(View v) {
                Intent intent = new Intent("com.example.a13522.xiaxian.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
