package com.example.a13522.xiaxian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
    EditText password;
    EditText account;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lohin);
       account = (EditText) findViewById(R.id.account);
       password = (EditText) findViewById(R.id.password);
       Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String admin= account.getText().toString().trim();
               String pwd= password.getText().toString().trim();
                if (admin.equals("")||pwd.equals("")){
                    Toast.makeText(getApplicationContext(),"帐号或者密码为空",Toast.LENGTH_SHORT).show();
                }else if (admin.equals("admin")&&pwd.equals("123456")){
                    //实现跳转  在登录界面跳转到主函数上去  你可以将MainActivity理解为登录后的界面
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"帐号或者密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
